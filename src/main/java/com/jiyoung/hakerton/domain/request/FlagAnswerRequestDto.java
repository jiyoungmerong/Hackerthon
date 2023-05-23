package com.jiyoung.hakerton.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FlagAnswerRequestDto {

    @NotEmpty
    private String answer;
}