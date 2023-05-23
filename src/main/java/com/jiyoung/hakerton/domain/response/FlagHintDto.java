package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Flag;

@Getter
public class FlagHintDto {
    private String hint;

    public FlagHintDto(Flag flag) {
        this.hint = flag.getHint();
    }
}