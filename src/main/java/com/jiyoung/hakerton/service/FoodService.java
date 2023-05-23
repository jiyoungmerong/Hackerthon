package com.jiyoung.hakerton.service;

import com.jiyoung.hakerton.domain.Food;
import com.jiyoung.hakerton.domain.request.FoodAnswerRequestDto;
import com.jiyoung.hakerton.domain.response.FoodAnswerAndExplainDto;
import com.jiyoung.hakerton.domain.response.FoodAnswerResponseDto;
import com.jiyoung.hakerton.domain.response.FoodHintDto;
import com.jiyoung.hakerton.domain.response.FoodQuestionDto;
import com.jiyoung.hakerton.exception.FoodNotFoundException;
import com.jiyoung.hakerton.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class FoodService {

    private final FoodRepository foodRepository;

    //문제, 사진, 객관식 문제
    public List<FoodQuestionDto> getFoodQuestion() {
        List<Food> foodList = foodRepository.findAll();
        return foodList.stream().map(food -> new FoodQuestionDto(food)).collect(Collectors.toList());
    }

    //힌트 주기
    public FoodHintDto getFoodHint(Long foodId) {
        Food food = findFood(foodId);
        return new FoodHintDto(food);
    }


    //정답이 맞는지 확인
    public FoodAnswerResponseDto checkCorrectAnswer(Long foodId, FoodAnswerRequestDto foodAnswerRequestDto) {
        Food food = findFood(foodId);
        Boolean isCorrected;
        if (food.getAnswer().equals(foodAnswerRequestDto.getAnswer())) {
            isCorrected = true;
        } else {
            isCorrected = false;}
        return new FoodAnswerResponseDto(isCorrected);
    }

    //정답과 해설 보내주기
    public FoodAnswerAndExplainDto getFoodAnswerAndExplain(Long foodId) {
        Food food = findFood(foodId);
        return new FoodAnswerAndExplainDto(food);
    }

    private Food findFood(Long foodId) {
        return foodRepository
                .findById(foodId)
                .orElseThrow(()-> FoodNotFoundException.EXCEPTION);
    }

}