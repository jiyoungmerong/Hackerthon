package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Food;
import lombok.Getter;

@Getter
public class FoodAnswerAndExplainDto {

    private String answer;

    private String info;

    public FoodAnswerAndExplainDto(Food food) {
        this.answer = food.getAnswer();
        this.info = food.getInfo();
    }

}