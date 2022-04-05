package com.sparta.milestone03advanced.service;

import com.sparta.milestone03advanced.dto.restaurant.RestaurantRequestDto;
import com.sparta.milestone03advanced.dto.restaurant.RestaurantResponseDto;
import com.sparta.milestone03advanced.model.Restaurant;
import com.sparta.milestone03advanced.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    // 레스토랑 등록
    public RestaurantResponseDto postRestaurant(RestaurantRequestDto requestDto){
        // 유효성 검사 시행 필요

        return new RestaurantResponseDto(restaurantRepository.save(new Restaurant(requestDto)));
    }

    // 레스토랑 검색
    public List<RestaurantResponseDto> getRestaurant(){
        List<RestaurantResponseDto> responseDtos = new ArrayList<>();
        for ( Restaurant restaurant : restaurantRepository.findAll() ){
            responseDtos.add(new RestaurantResponseDto(restaurant));
        }
        return responseDtos;
    }
}
