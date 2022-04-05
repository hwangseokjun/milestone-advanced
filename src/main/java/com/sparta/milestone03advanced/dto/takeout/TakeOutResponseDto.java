package com.sparta.milestone03advanced.dto.takeout;

import com.sparta.milestone03advanced.model.Restaurant;
import com.sparta.milestone03advanced.model.TakeOut;
import com.sparta.milestone03advanced.model.TakeOutFood;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TakeOutResponseDto {
    private String restaurantName;
    private List<TakeOutFoodResponseDto> foods = new ArrayList<>();
    private int deliveryFee;
    private int totalPrice;

    public TakeOutResponseDto(Restaurant restaurant){
        this.restaurantName = restaurant.getName();
        this.deliveryFee = restaurant.getDeliveryFee();
    }

    public TakeOutResponseDto(TakeOut takeOut){
        this.restaurantName = takeOut.getRestaurantName();
        this.deliveryFee = takeOut.getDeliveryFee();
        this.totalPrice = takeOut.getTotalPrice();
        for (TakeOutFood takeOutFood : takeOut.getTakeOutFoods()){
            foods.add(new TakeOutFoodResponseDto(takeOutFood));
        }
    }
}
