package com.amvb.service;

import com.amvb.DTOs.RestaurantDto;
import com.amvb.DTOs.RestaurantMenuDto;
import com.amvb.entity.RestaurantEntity;
import com.amvb.entity.RestaurantMenuEntity;
import com.amvb.repository.RestaurantRepo;
import com.amvb.utils.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService{

    final RestaurantRepo restaurantRepo;
    final RestaurantMapper restaurantMapper;

    //TODO
    @Override
    public RestaurantDto findById(int id) {
        log.info(restaurantRepo.findById(id).toString());
        log.info(restaurantMapper.entityToDto(restaurantRepo.findById(id).orElse(null)).toString());
        return  restaurantMapper.entityToDto(restaurantRepo.findById(id).orElse(null));
    }

    //TODO
    @Override
    public List<RestaurantDto> findByName(String name) {
        return List.of();
    }

    //TODO
    @Override
    public List<RestaurantDto> findByRating(String rating) {
        return List.of();
    }

    @Override
    public List<RestaurantDto> findAllRestaurants(int pageNumber, int pageSize) {
        Page<RestaurantEntity> restaurants=restaurantRepo.findAll(PageRequest.of(pageNumber, pageSize));
        return restaurantMapper.entityListToDtoList(restaurants.getContent());
    }

    @Override
    public void saveRestaurant(RestaurantDto restaurantDto) {
        restaurantRepo.save(restaurantMapper.dtoToEntity(restaurantDto));
    }

    @Override
    public void saveRestaurants(List<RestaurantDto> restaurantDtos) {
        restaurantRepo.saveAll(restaurantMapper.DtoListToEntityList(restaurantDtos));
    }

    @Override
    public void deleteAllRestaurants() {
        restaurantRepo.deleteAll();
    }
}
