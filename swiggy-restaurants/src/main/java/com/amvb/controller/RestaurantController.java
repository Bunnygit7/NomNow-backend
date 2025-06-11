package com.amvb.controller;

import com.amvb.DTOs.RestaurantDto;
import com.amvb.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RestaurantController {

    private final RestaurantService  restaurantService;

    @PostMapping
    public void addRestaurant(@RequestBody RestaurantDto restaurantDto){
        restaurantService.saveRestaurant(restaurantDto);

    }

    @PostMapping("/add")
    public void addRestaurants(@RequestBody List<RestaurantDto> restaurantDtos){
        restaurantService.saveRestaurants(restaurantDtos);
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public List<RestaurantDto> getRestaurants(@PathVariable int  pageNumber,@PathVariable int pageSize) {
        return restaurantService.findAllRestaurants(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public RestaurantDto getRestaurant(@PathVariable int id) {
        return restaurantService.findById(id);

    }
//    @GetMapping("/get")
//    public List<RestaurantDto> getRestaurantsWithMenu(){
//        return restaurantService.findAllRestaurantsWithMenu();
//    }

    @DeleteMapping("/all")
    public void deleteAllRestaurants(){
        restaurantService.deleteAllRestaurants();
    }
}
