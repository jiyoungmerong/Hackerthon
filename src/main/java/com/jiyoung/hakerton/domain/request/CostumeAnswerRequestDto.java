package com.jiyoung.hakerton.domain.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CostumeAnswerRequestDto {

    @NotEmpty
    private String answer;
}