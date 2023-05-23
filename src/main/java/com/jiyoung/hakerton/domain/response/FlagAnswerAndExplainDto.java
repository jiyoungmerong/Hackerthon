package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Flag;
import lombok.Getter;

@Getter
public class FlagAnswerAndExplainDto {

    private String answer;

    private String info;

    public FlagAnswerAndExplainDto(Flag flag) {
        this.answer = flag.getAnswer();
        this.info = flag.getInfo();
    }
}