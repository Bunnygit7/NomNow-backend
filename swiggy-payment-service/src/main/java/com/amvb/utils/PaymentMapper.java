package com.amvb.utils;

import com.amvb.DTOs.OrderDTO;
import com.amvb.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentEntity dtoToEntity(OrderDTO orderDTO);
}
