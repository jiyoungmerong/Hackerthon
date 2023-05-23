package com.jiyoung.hakerton.controller;

import com.jiyoung.hakerton.domain.request.LandmarkRequestDto;
import com.jiyoung.hakerton.domain.response.LandmarkAnswerAndExplainDto;
import com.jiyoung.hakerton.domain.response.LandmarkAnswerResponseDto;
import com.jiyoung.hakerton.domain.response.LandmarkHintDto;
import com.jiyoung.hakerton.domain.response.LandmarkQuestionDto;
import com.jiyoung.hakerton.service.LandmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/landmark")
public class LandmarkController {

    private final LandmarkService landmarkService;

    @GetMapping("/question")
    public List<LandmarkQuestionDto> getLandmarkQuestion() {
        return landmarkService.getFoodQuestion();
    }

    @GetMapping("/hint/{landmarkId}")
    public LandmarkHintDto getLandmarkHint(@PathVariable Long landmarkId) {
        return landmarkService.getLandmarkHint(landmarkId);
    }

    @GetMapping("/check-answer/{landmarkId}")
    public LandmarkAnswerResponseDto checkLandmarkAnswer(@PathVariable Long landmarkId,
                                                         @RequestBody LandmarkRequestDto landmarkRequestDto) {
        return landmarkService.checkCorrectAnswer(landmarkId, landmarkRequestDto);
    }

    @GetMapping("/answer/{landmarkId}")
    public LandmarkAnswerAndExplainDto getLandmarkAnswerAndExplain(@PathVariable Long landmarkId) {
        return landmarkService.getLandmarkAnswerAndExplain(landmarkId);
    }


}