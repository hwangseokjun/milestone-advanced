package com.sparta.milestone03advanced.service;

import com.sparta.milestone03advanced.dto.food.FoodRequestDto;
import com.sparta.milestone03advanced.dto.food.FoodResponseDto;
import com.sparta.milestone03advanced.model.Food;
import com.sparta.milestone03advanced.model.Restaurant;
import com.sparta.milestone03advanced.repository.FoodRepository;
import com.sparta.milestone03advanced.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

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
        // 유효성 검사 시행
        isValid(restaurantId, requestDtos);
        // 음식 등록
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("음식점이 존재하지 않습니다."));
        List<FoodResponseDto> responseDtos = new ArrayList<>();
        for ( FoodRequestDto requestDto : requestDtos ){
            responseDtos.add(new FoodResponseDto(foodRepository.save(new Food(restaurant, requestDto))));
        }
        return responseDtos;
    }

    // 유효성 검사 시행 메소드
    private void isValid(Long restaurantId, List<FoodRequestDto> requestDtos){

        // 음식이름 입력 중복 검사
        if (!requestDtos.stream()
                .map(FoodRequestDto::getName)
                .allMatch(new HashSet<>()::add)){
            throw new IllegalArgumentException("같은 음식의 중복 등록은 허용되지 않습니다.");
        }

        // 음식 목록 가져오기
        List<Food> foods = foodRepository.findByRestaurant_Id(restaurantId);

        // 음식가격 검사 및 음식테이블 중복 검사
        for (FoodRequestDto requestDto : requestDtos){
            if (requestDto.getPrice() < 100 || requestDto.getPrice() > 1_000_000){
                throw new IllegalArgumentException("음식가격은 100 ~ 1,000,000 사이로 입력해 주세요.");
            }
            if (requestDto.getPrice() % 100 != 0){
                throw new IllegalArgumentException("음식가격은 100원 단위로 입력해 주세요.");
            }
            for (Food food : foods){
                if ( food.getName().equals(requestDto.getName()) ){
                    throw new IllegalArgumentException("같은 음식의 중복 등록은 허용되지 않습니다.");
                }
            }
        }
    }

}
