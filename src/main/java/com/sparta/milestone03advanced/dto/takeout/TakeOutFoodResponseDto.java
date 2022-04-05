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

    public TakeOutFoodResponseDto(int quantinty, Food food){
        this.name = food.getName();
        this.quantity = quantinty;
        this.price = food.getPrice() * quantinty;
    }

    public TakeOutFoodResponseDto(TakeOutFood takeOutFood){
        this.name = takeOutFood.getName();
        this.quantity = takeOutFood.getQuantinty();
        this.price = takeOutFood.getPrice();
    }
}
