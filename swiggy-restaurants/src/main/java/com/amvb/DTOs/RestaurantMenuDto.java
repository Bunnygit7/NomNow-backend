package com.amvb.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantMenuDto {

    private String menuItem;
    private String description;
    private String menuItemImgUrl;
    private String menuType;
    private Double price;
}
