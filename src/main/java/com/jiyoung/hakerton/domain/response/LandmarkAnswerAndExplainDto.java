package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Landmark;
import lombok.Getter;

@Getter
public class LandmarkAnswerAndExplainDto {

    private String answer;

    private String info;

    public LandmarkAnswerAndExplainDto(Landmark landmark) {
        this.answer = landmark.getAnswer();
        this.info = landmark.getInfo();
    }
}