package com.jiyoung.hakerton.controller;

import com.jiyoung.hakerton.domain.request.CostumeAnswerRequestDto;
import com.jiyoung.hakerton.domain.response.CostumeAnswerAndExplainDto;
import com.jiyoung.hakerton.domain.response.CostumeAnswerResponseDto;
import com.jiyoung.hakerton.domain.response.CostumeHintDto;
import com.jiyoung.hakerton.domain.response.CostumeQuestionDto;
import com.jiyoung.hakerton.service.CostumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/costume")
public class CostumeController {

    private final CostumeService costumeService;

    @GetMapping("/question")
    public List<CostumeQuestionDto> getCostumeQuestion() {
        return costumeService.getCostumeQuestion();
    }

    @GetMapping("/hint/{costumeId}")
    public CostumeHintDto getCostumeHint(@PathVariable Long costumeId) {
        return costumeService.getCostumeHint(costumeId);
    }

    @GetMapping("/check-answer/{costumeId}")
    public CostumeAnswerResponseDto checkCostumeAnswer(@PathVariable Long costumeId,
                                                       @RequestBody CostumeAnswerRequestDto costumeAnswerRequestDto) {
        return costumeService.checkCorrectAnswer(costumeId, costumeAnswerRequestDto);
    }

    @GetMapping("/answer/{costumeId}")
    public CostumeAnswerAndExplainDto getCostumeAnswerAndExplain(@PathVariable Long costumeId) {
        return costumeService.getCostumeAnswerAndExplain(costumeId);
    }
}