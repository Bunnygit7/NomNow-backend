package com.amvb.repository;

import com.amvb.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<RestaurantEntity, Integer> {
}
