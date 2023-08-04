package com.example.demo2.domain.test;

import com.example.demo2.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryTestRepository implements TestRepository {

    private final List<Member> collectors = new ArrayList<>();

    // Create
    @Override
    public Long save(Member member) {
        collectors.add(member);
        System.out.println("Save Result = " + collectors);
        return member.getId();
    }

    // Read
    @Override
    public Member findById(Long id) {

        return collectors.stream().filter(member -> id == member.getId()).findAny().orElse(null);
    }

    @Override
    public Long update(Long id, Member member) {
        collectors.stream().filter(originMember -> originMember.getId() == id).findAny().ifPresent(originMember -> {
            originMember.setId(member.getId());
            originMember.setName(member.getName());
            originMember.setGrade(member.getGrade());
        });

        System.out.println("Updated Result = " + collectors);

        return 1L;
    }

    @Override
    public Long delete(Long id) {
        collectors.removeIf(member -> member.getId() == id);
        System.out.println("Deleted Result = " + collectors);
        return 1L;
    }
}
