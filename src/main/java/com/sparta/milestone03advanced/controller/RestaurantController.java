package com.sparta.milestone03advanced.controller;

import com.sparta.milestone03advanced.dto.restaurant.RestaurantRequestDto;
import com.sparta.milestone03advanced.dto.restaurant.RestaurantResponseDto;
import com.sparta.milestone03advanced.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    // 레스토랑 읽기
    @GetMapping("/restaurants")
    public List<RestaurantResponseDto> readRestaurant(){
        return restaurantService.getRestaurant();
    }

    // 레스토랑 등록하기
    @PostMapping("/restaurant/register")
    public RestaurantResponseDto registerRestaurant(@RequestBody RestaurantRequestDto requestDto){
        return restaurantService.postRestaurant(requestDto);
    }
}
