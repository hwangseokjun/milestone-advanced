package com.sparta.milestone03advanced.repository;

import com.sparta.milestone03advanced.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
