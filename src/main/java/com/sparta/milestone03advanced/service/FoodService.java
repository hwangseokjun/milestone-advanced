package com.sparta.milestone03advanced.service;

import com.sparta.milestone03advanced.dto.food.FoodRequestDto;
import com.sparta.milestone03advanced.dto.food.FoodResponseDto;
import com.sparta.milestone03advanced.model.Food;
import com.sparta.milestone03advanced.model.Restaurant;
import com.sparta.milestone03advanced.repository.FoodRepository;
import com.sparta.milestone03advanced.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    FoodRepository foodRepository;

    // 음식 검색
    public List<FoodResponseDto> getFoods(Long restaurantId){
        List<FoodResponseDto> responseDtos = new ArrayList<>();
        for(Food food : foodRepository.findByRestaurant_Id(restaurantId)){
            responseDtos.add(new FoodResponseDto(food));
        }
        return responseDtos;
    }

    // 음식 등록
    public List<FoodResponseDto> postFoods(Long restaurantId, List<FoodRequestDto> requestDtos){

        // 유효성 검사 시행 필요

        // 음식 등록
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("음식점이 존재하지 않습니다."));
        List<FoodResponseDto> responseDtos = new ArrayList<>();
        for ( FoodRequestDto requestDto : requestDtos ){
            responseDtos.add(new FoodResponseDto(foodRepository.save(new Food(restaurant, requestDto))));
        }
        return responseDtos;
    }

}
