package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Costume;
import lombok.Getter;

@Getter
public class CostumeAnswerAndExplainDto {

    private String answer;

    private String info;

    public CostumeAnswerAndExplainDto(Costume costume) {
        this.answer = costume.getAnswer();
        this.info = costume.getInfo();
    }
}