package com.sparta.milestone03advanced.controller;

import com.sparta.milestone03advanced.dto.restaurant.RestaurantRequestDto;
import com.sparta.milestone03advanced.dto.restaurant.RestaurantResponseDto;
import com.sparta.milestone03advanced.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    // 레스토랑 읽기
    // 주소지를 추가로 전송받으며, x, y값이 항상 있다는 전재 하에 설게합니다.
    @GetMapping("/restaurants")
    public List<RestaurantResponseDto> readRestaurant(@RequestParam("x") double x,
                                                      @RequestParam("y") double y ){
        return restaurantService.getRestaurant(x, y);
    }

    // 레스토랑 등록하기
    @PostMapping("/restaurant/register")
    public RestaurantResponseDto registerRestaurant(@RequestBody RestaurantRequestDto requestDto){
        return restaurantService.postRestaurant(requestDto);
    }
}
