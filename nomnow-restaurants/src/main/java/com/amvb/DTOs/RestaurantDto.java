package com.amvb.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto {

    private Integer restaurantId;
    private String restaurantName;
    private String rating;
    private String imgUrl;
    private String location;
    private List<String> menuTypes;
    private List<RestaurantMenuDto> menus;
}
