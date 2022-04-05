package com.sparta.milestone03advanced.service;

import com.sparta.milestone03advanced.dto.takeout.TakeOutFoodRequestDto;
import com.sparta.milestone03advanced.dto.takeout.TakeOutFoodResponseDto;
import com.sparta.milestone03advanced.dto.takeout.TakeOutRequestDto;
import com.sparta.milestone03advanced.dto.takeout.TakeOutResponseDto;
import com.sparta.milestone03advanced.model.Restaurant;
import com.sparta.milestone03advanced.model.TakeOut;
import com.sparta.milestone03advanced.model.TakeOutFood;
import com.sparta.milestone03advanced.repository.FoodRepository;
import com.sparta.milestone03advanced.repository.RestaurantRepository;
import com.sparta.milestone03advanced.repository.TakeOutFoodRepository;
import com.sparta.milestone03advanced.repository.TakeOutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TakeOutService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final TakeOutRepository takeOutRepository;
    private final TakeOutFoodRepository takeOutFoodRepository;

    // 주문 목록 가져오기
    public List<TakeOutResponseDto> getTakeOut(){
        List<TakeOutResponseDto> responseDtos = new ArrayList<>();
        List<TakeOut> takeOuts = takeOutRepository.findAll();
        for (TakeOut takeOut : takeOuts){
            responseDtos.add(new TakeOutResponseDto(takeOut));
        }
        return responseDtos;
    }

    // 주문 검증 후 저장하기
    public TakeOutResponseDto postTakeOut(TakeOutRequestDto requestDto){

        // 주문수량 검증
        for (TakeOutFoodRequestDto takeOutFoodRequestDto : requestDto.getFoods()){
            int quantity = takeOutFoodRequestDto.getQuantity();
            if ( quantity < 0 || quantity > 100){
                throw new IllegalArgumentException("주문수량은 0 ~ 100 사이로 입력해 주세요.");
            }
        }

        // TakeOutResponseDto 만들기
        Restaurant restaurant = restaurantRepository
                .findById(requestDto.getRestaurantId())
                .orElseThrow( () -> new NullPointerException("음식점이 존재하지 않습니다."));
        TakeOutResponseDto takeOutResponseDto = new TakeOutResponseDto(restaurant);

        // TakeOutFoodResponseDto 만들기
        List<TakeOutFoodResponseDto> takeOutFoodResponsDtos = new ArrayList<>();
        for (TakeOutFoodRequestDto takeOutFoodRequestDto : requestDto.getFoods()){
            takeOutFoodResponsDtos
                    .add(
                    new TakeOutFoodResponseDto(
                            takeOutFoodRequestDto.getQuantity(),
                            foodRepository
                            .findById(takeOutFoodRequestDto.getId())
                            .orElseThrow( () -> new NullPointerException("해당 음식이 존재하지 않습니다."))));
        }

        // TakeOutResponseDto 완성
        takeOutResponseDto.setFoods(takeOutFoodResponsDtos);
        takeOutResponseDto.setTotalPrice(takeOutFoodResponsDtos
                .stream()
                .mapToInt(TakeOutFoodResponseDto::getPrice)
                .sum() + takeOutResponseDto.getDeliveryFee());

        // 최소 주문 가격 검증
        if (takeOutResponseDto.getTotalPrice() - takeOutResponseDto.getDeliveryFee()
                < restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException(restaurant.getMinOrderPrice()+"원 이상 주문해 주세요.");
        }

        // 목록 저장 후 리턴하기
        return takeOutSave(takeOutResponseDto);
    }

    // 목록 저장 메소드
    public TakeOutResponseDto takeOutSave(TakeOutResponseDto responseDto){
        TakeOut takeOut = takeOutRepository.save(new TakeOut(responseDto));

        List<TakeOutFood> takeOutFoods = new ArrayList<>();
        for ( TakeOutFoodResponseDto takeOutFoodResponseDto : responseDto.getFoods() ){
            takeOutFoods.add(new TakeOutFood(takeOut, takeOutFoodResponseDto));
        }

        takeOutFoodRepository.saveAll(takeOutFoods);

        return responseDto;
    }
}
