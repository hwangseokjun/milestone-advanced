package com.sparta.milestone03advanced.controller;

import com.sparta.milestone03advanced.dto.SignupRequestDto;
import com.sparta.milestone03advanced.service.MemberListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberListService memberListService;

    // 회원가입
    @PostMapping("/user/signup")
    public void signup(@RequestBody SignupRequestDto signupRequestDto){
        memberListService.join(signupRequestDto);
    }
}
