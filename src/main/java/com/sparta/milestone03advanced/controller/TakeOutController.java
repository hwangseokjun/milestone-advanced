package com.sparta.milestone03advanced.controller;

import com.sparta.milestone03advanced.dto.takeout.TakeOutRequestDto;
import com.sparta.milestone03advanced.dto.takeout.TakeOutResponseDto;
import com.sparta.milestone03advanced.service.TakeOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TakeOutController {

    private final TakeOutService takeOutService;

    // 주문 읽기
    @GetMapping("/orders")
    public List<TakeOutResponseDto> readTakeOut(){
        return takeOutService.getTakeOut();
    }

    // 주문 등록하기
    @PostMapping("/order/request")
    public TakeOutResponseDto registerTakeOut(@RequestBody TakeOutRequestDto requestDto){
        return takeOutService.postTakeOut(requestDto);
    }
}
