package com.sparta.milestone03advanced.controller;

import com.sparta.milestone03advanced.dto.food.FoodRequestDto;
import com.sparta.milestone03advanced.dto.food.FoodResponseDto;
import com.sparta.milestone03advanced.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    // 메뉴 읽기
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> readMenu(@PathVariable Long restaurantId){
        return foodService.getFoods(restaurantId);
    }

    // 메뉴 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public List<FoodResponseDto> registerMenu(
            @PathVariable Long restaurantId,
            @RequestBody List<FoodRequestDto> requestDtos){
        return foodService.postFoods(restaurantId, requestDtos);
    }
}
