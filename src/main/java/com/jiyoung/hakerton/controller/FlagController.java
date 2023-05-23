package com.jiyoung.hakerton.controller;

import com.jiyoung.hakerton.domain.request.FlagAnswerRequestDto;
import com.jiyoung.hakerton.domain.response.FlagAnswerAndExplainDto;
import com.jiyoung.hakerton.domain.response.FlagAnswerResponseDto;
import com.jiyoung.hakerton.domain.response.FlagHintDto;
import com.jiyoung.hakerton.domain.response.FlagQuestionDto;
import com.jiyoung.hakerton.service.FlagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flag")
public class FlagController {

    private final FlagService flagService;

    @GetMapping("/question")
    public List<FlagQuestionDto> getFlagQuestion() {
        return flagService.getFlagQuestion();
    }

    @GetMapping("/hint/{flagId}")
    public FlagHintDto getFlagHint(@PathVariable Long flagId) {
        return flagService.getFlagHint(flagId);
    }

    @GetMapping("/check-answer/{flagId}")
    public FlagAnswerResponseDto checkFlagAnswer(@PathVariable Long flagId,
                                                 @RequestBody FlagAnswerRequestDto flagAnswerRequestDto) {
        return flagService.checkCorrectAnswer(flagId, flagAnswerRequestDto);
    }

    @GetMapping("/answer/{flagId}")
    public FlagAnswerAndExplainDto getFlagAnswerAndExplain(@PathVariable Long flagId) {
        return flagService.getFlagAnswerAndExplain(flagId);
    }
}