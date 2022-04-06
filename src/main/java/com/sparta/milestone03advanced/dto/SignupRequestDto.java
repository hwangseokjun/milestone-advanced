package com.sparta.milestone03advanced.dto;

import com.sparta.milestone03advanced.model.member.MemberRoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequestDto {
    private String userId;
    private String username;
    private String password;
    private MemberRoleEnum role;
}
