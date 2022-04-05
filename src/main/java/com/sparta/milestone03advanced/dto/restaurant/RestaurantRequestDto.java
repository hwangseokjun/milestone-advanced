package com.sparta.milestone03advanced.dto.restaurant;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantRequestDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
    private int x;
    private int y;
}
