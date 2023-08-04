package com.example.demo2.service;

import com.example.demo2.domain.member.Member;
import com.example.demo2.domain.test.MemoryTestRepository;
import com.example.demo2.domain.test.TestRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestServiceImpl implements TestService{

    private  final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    // Create
    @Override
    public Long joinTest(Member member) {
        return testRepository.save(member);
    }

    // Read
    @Override
    public Member findTestById(Long id) {
        return testRepository.findById((id));
    }

    // Update
    @Override
    public Long updateTest(Long id, Member member) {
        return testRepository.update(id, member);
    }

    // Delete

    @Override
    public Long deleteTest(Long id) {
        return testRepository.delete(id);
    }
}
