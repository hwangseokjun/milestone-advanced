package com.sparta.milestone03advanced.model;

import com.sparta.milestone03advanced.dto.food.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Food {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(Restaurant restaurant, FoodRequestDto requestDto){
        this.restaurant = restaurant;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}
