package com.jiyoung.hakerton.controller;


import com.jiyoung.hakerton.domain.request.FoodAnswerRequestDto;
import com.jiyoung.hakerton.domain.response.FoodAnswerAndExplainDto;
import com.jiyoung.hakerton.domain.response.FoodAnswerResponseDto;
import com.jiyoung.hakerton.domain.response.FoodHintDto;
import com.jiyoung.hakerton.domain.response.FoodQuestionDto;
import com.jiyoung.hakerton.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/question")
    public List<FoodQuestionDto> getFoodQuestion() {
        return foodService.getFoodQuestion();
    }

    @GetMapping("/hint/{foodId}")
    public FoodHintDto getFoodHint(@PathVariable Long foodId) {
        return foodService.getFoodHint(foodId);
    }

    @GetMapping("/check-answer/{foodId}")
    public FoodAnswerResponseDto checkFoodAnswer(@PathVariable Long foodId,
                                                 @RequestBody FoodAnswerRequestDto foodAnswerRequestDto) {
        return foodService.checkCorrectAnswer(foodId, foodAnswerRequestDto);
    }

    @GetMapping("/answer/{foodId}")
    public FoodAnswerAndExplainDto getFoodAnswerAndExplain(@PathVariable Long foodId) {
        return foodService.getFoodAnswerAndExplain(foodId);
    }
}