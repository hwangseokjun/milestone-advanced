package com.sparta.milestone03advanced.repository;

import com.sparta.milestone03advanced.model.member.MemberList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberListRepository extends JpaRepository<MemberList,Long> {
}
