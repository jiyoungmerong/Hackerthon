package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Landmark;
import lombok.Getter;

@Getter
public class LandmarkQuestionDto {

    private Long id;

    private String url;

    private String question;

    private String one;

    private String two;

    private String three;

    private String four;

    public LandmarkQuestionDto(Landmark landmark) {
        this.id = landmark.getId();
        this.url = landmark.getUrl();
        this.question = landmark.getQuestion();
        this.one = landmark.getChoice().getOne();
        this.two = landmark.getChoice().getTwo();
        this.three = landmark.getChoice().getThree();
        this.four = landmark.getChoice().getFour();
    }
}