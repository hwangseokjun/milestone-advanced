package com.sparta.milestone03advanced.dto.takeout;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TakeOutRequestDto {
    private Long restaurantId;
    private List<TakeOutFoodRequestDto> foods;
    private double x;
    private double y;
}
