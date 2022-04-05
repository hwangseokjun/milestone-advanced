package com.sparta.milestone03advanced.dto.restaurant;

import com.sparta.milestone03advanced.model.Restaurant;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantResponseDto {
    private Long id;
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
    private double x;
    private double y;

    public RestaurantResponseDto(Restaurant restaurant){
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.minOrderPrice = restaurant.getMinOrderPrice();
        this.deliveryFee = restaurant.getDeliveryFee();
        this.x = restaurant.getX();
        this.y = restaurant.getY();
    }
}
