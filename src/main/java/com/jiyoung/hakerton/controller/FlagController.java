package com.jiyoung.hakerton.controller;

import com.jiyoung.hakerton.domain.Flag;
import com.jiyoung.hakerton.domain.dto.FlagQuestionDTO;
import com.jiyoung.hakerton.repository.FlagRepository;
import com.jiyoung.hakerton.service.FlagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class FlagController {
    private Set<Long> flagId = new HashSet<>();

    private final FlagService flagService;
    private final FlagRepository flagRepository;

    @GetMapping("/flag")
    public List<FlagQuestionDTO> getFoodQuestion() {
        return flagService.getFlagQuestion();
    }

    @GetMapping("/flag/hint/{id}") // 힌트 가져오기
    public ResponseEntity<Map<String, String>> getHint(@PathVariable("id") Long id) {
        Optional<Flag> optionalHint = flagRepository.findById(id);
        if (optionalHint.isPresent()) {
            Flag flag = optionalHint.get();
            String hint = flag.getHint();
            Map<String, String> response = new HashMap<>();
            response.put("hint", hint);
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/answer/flag/{id}") // 정답 가져오기
    public ResponseEntity<Map<String, String>> getAnswer(@PathVariable("id") Long id) {
        Optional<Flag> optionalAnswer = flagRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            Flag flag = optionalAnswer.get();
            String answer = flag.getAnswer();
            Map<String, String> response = new HashMap<>();
            response.put("answer", answer);
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/info/flag/{id}") // 설명 가져오기
    public ResponseEntity<Map<String, String>> getInfo(@PathVariable("id") Long id) {
        Optional<Flag> optionalInfo = flagRepository.findById(id);
        if (optionalInfo.isPresent()) {
            Flag flag = optionalInfo.get();
            String info = flag.getInfo();
            Map<String, String> response = new HashMap<>();
            response.put("info", info);
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

