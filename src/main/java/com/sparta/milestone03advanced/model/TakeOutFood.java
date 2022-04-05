package com.sparta.milestone03advanced.model;

import com.sparta.milestone03advanced.dto.takeout.TakeOutFoodResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class TakeOutFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TakeOut takeOut;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    public TakeOutFood(TakeOut takeOut, TakeOutFoodResponseDto responseDto){
        this.takeOut = takeOut;
        this.name = responseDto.getName();
        this.quantity = responseDto.getQuantity();
        this.price = responseDto.getPrice();
    }
}
