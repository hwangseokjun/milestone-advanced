package com.sparta.milestone03advanced.dto.takeout;

import com.sparta.milestone03advanced.model.Food;
import com.sparta.milestone03advanced.model.TakeOutFood;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TakeOutFoodResponseDto {
    private String name;
    private int quantity;
    private int price;

    public TakeOutFoodResponseDto(int quantity, Food food){
        this.name = food.getName();
        this.quantity = quantity;
        this.price = food.getPrice() * quantity;
    }

    public TakeOutFoodResponseDto(TakeOutFood takeOutFood){
        this.name = takeOutFood.getName();
        this.quantity = takeOutFood.getQuantity();
        this.price = takeOutFood.getPrice();
    }
}
