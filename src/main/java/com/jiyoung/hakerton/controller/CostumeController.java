package com.jiyoung.hakerton.controller;

import com.jiyoung.hakerton.domain.Costume;
import com.jiyoung.hakerton.domain.dto.CostumeDTO;
import com.jiyoung.hakerton.domain.dto.CostumeQuestionDTO;
import com.jiyoung.hakerton.domain.dto.FlagQuestionDTO;
import com.jiyoung.hakerton.repository.CostumeRepository;
import com.jiyoung.hakerton.service.CostumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class CostumeController {
    private Set<Long> costumeId = new HashSet<>(); // 중복 제거하는 set함수

    private final CostumeService costumeService;
    private final CostumeRepository costumeRepository;

    @GetMapping("/costume")
    public List<CostumeQuestionDTO> getCostumeQuestion() {
        return costumeService.getCostumeQuestion();
    }

    @GetMapping("/costume/hint/{id}") // 힌트 가져오기
    public ResponseEntity<Map<String, String>> getHint(@PathVariable("id") Long id) {
        Optional<Costume> optionalHint = costumeRepository.findById(id);
        if (optionalHint.isPresent()) {
            Costume costume = optionalHint.get();
            String hint = costume.getHint();
            Map<String, String> response = new HashMap<>();
            response.put("hint", hint);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/answer/costume/{id}") // 정답 가져오기
    public ResponseEntity<Map<String, String>> getAnswer(@PathVariable("id") Long id) {
        Optional<Costume> optionalAnswer = costumeRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            Costume costume = optionalAnswer.get();
            String answer = costume.getAnswer();
            Map<String, String> response = new HashMap<>();
            response.put("answer", answer);
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/info/costume/{id}") // 설명 가져오기
    public ResponseEntity<Map<String, String>> getInfo(@PathVariable("id") Long id) {
        Optional<Costume> optionalInfo = costumeRepository.findById(id);
        if (optionalInfo.isPresent()) {
            Costume costume = optionalInfo.get();
            String info = costume.getInfo();
            Map<String, String> response = new HashMap<>();
            response.put("info", info);
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

