package com.sparta.milestone03advanced.repository;

import com.sparta.milestone03advanced.model.TakeOutFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TakeOutFoodRepository extends JpaRepository<TakeOutFood, Long> {
}
