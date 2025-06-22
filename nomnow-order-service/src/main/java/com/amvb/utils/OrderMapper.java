package com.amvb.utils;

import com.amvb.DTOs.OrderDTO;
import com.amvb.entity.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    OrderEntity dtoToEntity(OrderDTO orderDTO);
    List<OrderDTO> entityListToDtoList(List<OrderEntity> orderEntityList);
}
