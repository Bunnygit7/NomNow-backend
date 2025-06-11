package com.amvb.service;


import com.amvb.DTOs.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    public List<RestaurantDto>  findAllRestaurants(int  pageNumber, int pageSize);
    public List<RestaurantDto> findByName(String name);
    public List<RestaurantDto> findByRating(String rating);
    public void saveRestaurant(RestaurantDto restaurantDto);
    public RestaurantDto findById(int id);
    public void saveRestaurants(List<RestaurantDto> restaurantDtos);
    public void deleteAllRestaurants();
}
