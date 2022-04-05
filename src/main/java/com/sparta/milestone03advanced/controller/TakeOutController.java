package com.sparta.milestone03advanced.controller;

import com.sparta.milestone03advanced.dto.takeout.TakeOutRequestDto;
import com.sparta.milestone03advanced.dto.takeout.TakeOutResponseDto;
import com.sparta.milestone03advanced.service.TakeOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TakeOutController {

    @Autowired
    TakeOutService takeOutService;

    // 주문 읽기
    @GetMapping("/take-out")
    public List<TakeOutResponseDto> readTakeOut(){
        return takeOutService.getTakeOut();
    }

    // 주문 등록하기
    @PostMapping("/take-out/request")
    public TakeOutResponseDto registerTakeOut(@RequestBody TakeOutRequestDto requestDto){
        return takeOutService.postTakeOut(requestDto);
    }
}
