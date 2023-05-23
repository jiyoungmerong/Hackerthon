package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Food;
import lombok.Getter;

@Getter
public class FoodQuestionDto {

    private Long id;

    private String url;

    private String question;

    private String one;

    private String two;

    private String three;

    private String four;

    public FoodQuestionDto(Food food) {
        this.id = food.getId();
        this.url = food.getUrl();
        this.question = food.getQuestion();
        this.one = food.getChoice().getOne();
        this.two = food.getChoice().getTwo();
        this.three = food.getChoice().getThree();
        this.four = food.getChoice().getFour();
    }
}