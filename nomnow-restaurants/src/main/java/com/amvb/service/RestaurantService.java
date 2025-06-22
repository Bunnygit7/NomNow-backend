package com.amvb.service;


import com.amvb.DTOs.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDto>  findAllRestaurants(int  pageNumber, int pageSize);
    List<RestaurantDto> findByName(String name);
    List<RestaurantDto> findByRating(String rating);
    void saveRestaurant(RestaurantDto restaurantDto);
    RestaurantDto findById(int id);
    void saveRestaurants(List<RestaurantDto> restaurantDtos);
    void deleteAllRestaurants();
}
