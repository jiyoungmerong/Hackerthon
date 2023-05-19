package com.jiyoung.hakerton.domain.dto;

import com.jiyoung.hakerton.domain.Costume;
import lombok.Getter;
@Getter
public class CostumeQuestionDTO {
    private Long id;
    private String url;
    private String question;
    private String one;

    private String two;

    private String three;

    private String four;

    public CostumeQuestionDTO(Costume costume) {
        this.id = costume.getId();
        this.url = costume.getUrl();
        this.question = costume.getQuestion();
        this.one = costume.getChoice().getOne();
        this.two = costume.getChoice().getTwo();
        this.three = costume.getChoice().getThree();
        this.four = costume.getChoice().getFour();
    }
}

