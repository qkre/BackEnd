package com.example.demo2.service;

import com.example.demo2.domain.member.Member;

import java.util.Map;

public interface TestService {

    // 테스트 생성 - C
    Long joinTest(Member member);

    // 테스트 단건 조회 - R
    Member findTestById(Long id);

    // 테스트 수정 - U
    Long updateTest(Long id, Member member);

    // 테스트 삭제 - D
    Long deleteTest(Long id);
}
