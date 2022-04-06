package com.sparta.milestone03advanced.service;

import com.sparta.milestone03advanced.dto.SignupRequestDto;
import com.sparta.milestone03advanced.model.member.MemberList;
import com.sparta.milestone03advanced.repository.MemberListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberListService {

    @Autowired
    MemberListRepository memberListRepository;

    public void join(SignupRequestDto signupRequestDto){
        // 기본 유효성 검사 실시

        // 회원 중복 검사
        MemberList member = new MemberList(signupRequestDto);

        //회원 등록
        memberListRepository.save(member);
    }
}
