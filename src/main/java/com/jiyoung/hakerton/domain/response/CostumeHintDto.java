package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Costume;
import lombok.Getter;

@Getter
public class CostumeHintDto {
    private String hint;

    public CostumeHintDto(Costume costume) {
        this.hint = costume.getHint();
    }
}