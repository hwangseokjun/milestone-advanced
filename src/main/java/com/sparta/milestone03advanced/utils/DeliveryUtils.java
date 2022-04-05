package com.sparta.milestone03advanced.utils;

import org.springframework.stereotype.Component;

@Component
public class DeliveryUtils {

    // 두 점 사이의 거리 구하기
    public double getDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    // 거리 차이에 따른 배달비 할증 구하기
    public int getDistancePremium(double distance){
        return (int)Math.floor(distance)*500;
    }
}
