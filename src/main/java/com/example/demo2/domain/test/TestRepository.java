package com.example.demo2.domain.test;

import com.example.demo2.domain.member.Member;

import java.util.Map;

public interface TestRepository {

    // C
    Long save(Member member);

    // R
    Member findById(Long id);

    // U
    Long update(Long id, Member member);

    // D
    Long delete(Long id);
}
