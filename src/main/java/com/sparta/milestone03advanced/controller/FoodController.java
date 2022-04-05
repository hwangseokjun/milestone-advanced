package com.sparta.milestone03advanced.controller;

import com.sparta.milestone03advanced.dto.food.FoodRequestDto;
import com.sparta.milestone03advanced.dto.food.FoodResponseDto;
import com.sparta.milestone03advanced.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    // 메뉴 읽기
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> readMenu(@PathVariable Long restaurantId){
        return foodService.getFoods(restaurantId);
    }

    // 메뉴 등록하기
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerMenu(
            @PathVariable Long restaurantId,
            @RequestBody List<FoodRequestDto> requestDtos){
        foodService.postFoods(restaurantId, requestDtos);
    }
}
