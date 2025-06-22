package com.amvb.utils;

import com.amvb.DTOs.RestaurantDto;
import com.amvb.DTOs.RestaurantMenuDto;
import com.amvb.entity.RestaurantEntity;
import com.amvb.entity.RestaurantMenuEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDto entityToDto(RestaurantEntity entity);
    RestaurantEntity dtoToEntity(RestaurantDto dto);
    RestaurantMenuDto entityMenuToMenuDto(RestaurantMenuEntity entityMenu);
    RestaurantMenuEntity menuDtoToEntityMenu(RestaurantMenuDto menuDto);

    List<RestaurantDto> entityListToDtoList(List<RestaurantEntity> restaurantEntityList);
    List<RestaurantEntity> DtoListToEntityList(List<RestaurantDto> restaurantDtoList);
}
