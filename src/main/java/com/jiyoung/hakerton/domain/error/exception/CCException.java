package com.jiyoung.hakerton.domain.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CCException extends RuntimeException{

    private ErrorCode errorCode;
}