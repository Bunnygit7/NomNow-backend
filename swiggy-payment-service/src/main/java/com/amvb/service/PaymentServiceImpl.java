package com.amvb.service;

import com.amvb.DTOs.OrderDTO;
import com.amvb.broker.OrderBroker;
import com.amvb.entity.PaymentEntity;
import com.amvb.entity.PaymentStatus;
import com.amvb.repository.PaymentRepository;
import com.amvb.utils.PaymentMapper;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;


@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final OrderBroker orderBroker;

    @Value("razorpay.key")
    private String razorpayKey;
    @Value("razorpay.secret")
    private String razorpaySecret;

    private final Random random = new Random();

    @Override
    public void processPayment(OrderDTO orderDTO) {


/*        PaymentEntity paymentEntity=PaymentEntity.builder()
                .paymentStatus(PaymentStatus.PAYMENT_SUCCESS)
                .transactionId(orderDTO.getTransactionId())
                .userName(orderDTO.getUserName())
                .txnDateAndTime(LocalDateTime.now())
                .build();
        paymentRepository.save(paymentEntity);*/

        PaymentEntity payment = paymentMapper.dtoToEntity(orderDTO);
        payment.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESS);
        payment.setTxnDateAndTime(LocalDateTime.now());

        PaymentEntity paymentEntity = paymentRepository.save(payment);

        orderDTO.setPaymentId(paymentEntity.getPaymentId());
        //Make a call to order service to create order
        orderBroker.createOrder(orderDTO);
    }

    @Override
    public Map<String, Object> createOrder(Map<String, Object> data) {
        try {
            RazorpayClient razorpayClient = new RazorpayClient("rzp_test_xmTfxvzVCyaxLL", "humK9jqEM9qJzf7QHTGu8q2r");
//            RazorpayClient razorpayClient=new RazorpayClient(razorpayKey,razorpaySecret);
            int amount = Integer.parseInt(data.get("amount").toString()) * 100; //Razorpay needs in paise → 50000
            JSONObject options = new JSONObject();
            options.put("amount", amount);
            options.put("currency", "INR");
            String receipt = "txn_" + random.nextInt(1000) + 1; // TODO : instead of random get from db and store next number
            options.put("receipt", receipt); //TODO : save to db
            options.put("payment_capture", 1);
            Order order = razorpayClient.orders.create(options);
            return Map.of(
                    "id", order.get("id"),
                    "amount", order.get("amount"),
                    "currency", order.get("currency")
            );

        } catch (Exception e) {
            return Map.of("error-message", e.getMessage());
        }

    }

    @Override
    public String verifyPayment(Map<String, String> data) {

        String orderId = data.get("razorpay_order_id");
        String paymentId = data.get("razorpay_payment_id");
        String razorpaySignature = data.get("razorpay_signature");
        Double amountPaid = Double.valueOf(data.get("razorpay_amount_paid"));
        String response=null;

        String payload = orderId + '|' + paymentId;

        try {
            String actualSignature = hmacSha256(payload, "humK9jqEM9qJzf7QHTGu8q2r");//todo ::hardcoded
            if (razorpaySignature.equals(actualSignature)) {
                //TODO

                OrderDTO orderDTO = OrderDTO.builder()
                        .transactionId(paymentId)
                        .orderStatus("DELIVERED")
                        .orderCreatedTime(LocalDateTime.now())
                        .amountPaid(amountPaid/100)
                        .userName("bunnyForTemp")
                        .build();
           processPayment(orderDTO);

                log.info("Payment verification successful");
//                return ResponseEntity.ok("Payment verified successfully!");
                response="success";
            }
        } catch (Exception e) {
            log.info("Payment verification failed");
//            return ResponseEntity.status(500).body("Verification error: " + e.getMessage());
            response=e.getMessage();
        }

        return response;
    }

    // HMAC-SHA256 hash function
    private String hmacSha256(String payload, String secret) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secretKey);
        byte[] hash = sha256_HMAC.doFinal(payload.getBytes());
        return Hex.encodeHexString(hash);
    }
}
