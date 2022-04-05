package com.sparta.milestone03advanced.service;

import com.sparta.milestone03advanced.dto.restaurant.RestaurantRequestDto;
import com.sparta.milestone03advanced.dto.restaurant.RestaurantResponseDto;
import com.sparta.milestone03advanced.model.Restaurant;
import com.sparta.milestone03advanced.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    // 레스토랑 등록
    public RestaurantResponseDto postRestaurant(RestaurantRequestDto requestDto){
        // 유효성 검사 시행
        isValid(requestDto);
        // 레스토랑 저장
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

    // 유효성 검사 시행 메소드
    private void isValid(RestaurantRequestDto requestDto){

        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        if (minOrderPrice < 1_000 || minOrderPrice > 100_000){
            throw new IllegalArgumentException("최소주문가격은 1,000 ~ 100,000 사이로 입력해 주세요.");
        }
        if (minOrderPrice % 100 != 0){
            throw new IllegalArgumentException("최소주문가격은 100원 단위로 입력해 주세요.");
        }
        if (deliveryFee < 0 || deliveryFee > 10_000){
            throw new IllegalArgumentException("배달비용은 0 ~ 10,000 사이로 입력해 주세요.");
        }
        if (deliveryFee % 500 !=0){
            throw new IllegalArgumentException("배달비용은 500원 단위로 입력해 주세요.");
        }
    }
}
