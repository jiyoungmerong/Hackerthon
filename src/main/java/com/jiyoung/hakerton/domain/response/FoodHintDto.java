package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Food;
import lombok.Getter;

@Getter
public class FoodHintDto {

    private String hint;

    public FoodHintDto(Food food) {
        this.hint = food.getHint();
    }
}