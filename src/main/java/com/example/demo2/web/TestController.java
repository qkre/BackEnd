package com.example.demo2.web;

import com.example.demo2.domain.member.Member;
import com.example.demo2.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/latest")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    // Create
    @PostMapping("/test") // Post 는 데이터를 생성할 때 사용하는 HTTP 프로토콜 방식
    public ResponseEntity<String> create(@RequestBody Map<String, String> map) {
        System.out.println("map.id = " + map.get("id"));
        System.out.println("map.name = " + map.get("name"));
        System.out.println("map.grade = " + map.get("grade"));

        Member member = new Member(Long.parseLong(map.get("id")), map.get("name"), map.get("grade"));
        Long result = testService.joinTest(member);
        System.out.println("result = " + result);

        return ResponseEntity.ok("CREATED");
    }

    // Read - 단건 조회
    @GetMapping("/test/{id}") // Get 은 데이터를 읽어들일 때 사용하는 HTTP 프로토콜 방식
    public ResponseEntity<String> read(@PathVariable Long id) {
        System.out.println("id = " + id);

        Member result = testService.findTestById(id);
        System.out.println("result = " + result);

        return ResponseEntity.ok("Hello world! KNU");
    }

    // Update
    @PutMapping("/test/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Map<String, String> map) {
        System.out.println("id = " + id);
        System.out.println("map.id = " + map.get("id"));
        System.out.println("map.name = " + map.get("name"));
        System.out.println("map.grade = " + map.get("grade"));

        Member member = new Member(Long.parseLong(map.get("id")), map.get("name"), map.get("grade"));
        Long result = testService.updateTest(member.getId(), member);

        return ResponseEntity.ok("UPDATED");
    }

    // Delete
    @DeleteMapping("/test/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        System.out.println("id = " + id);

        Long result = testService.deleteTest(id);

        return ResponseEntity.ok("DELETED");
    }
}
