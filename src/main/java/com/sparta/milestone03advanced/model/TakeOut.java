package com.sparta.milestone03advanced.model;

import com.sparta.milestone03advanced.dto.takeout.TakeOutResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class TakeOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    @OneToMany(mappedBy = "takeOut", fetch = FetchType.EAGER)
    private List<TakeOutFood> takeOutFoods;

    public TakeOut(TakeOutResponseDto responseDto){
        this.restaurantName = responseDto.getRestaurantName();
        this.deliveryFee = responseDto.getDeliveryFee();
        this.totalPrice = responseDto.getTotalPrice();
    }

}
