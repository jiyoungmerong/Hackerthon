package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Landmark;
import lombok.Getter;

@Getter
public class LandmarkHintDto {

    private String hint;

    public LandmarkHintDto(Landmark landmark) {
        this.hint = landmark.getHint();
    }
}