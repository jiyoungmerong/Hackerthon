package com.jiyoung.hakerton.domain.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    FOOD_NOT_FOUND(404, "해당하는 음식 관련 문제가 없습니다."),
    LANDMARK_NOT_FOUND(404, "해당하는 랜드마크 관련 문제가 없습니다."),
    FLAG_NOT_FOUND(404,"해당하는 국기 관련 문제가 없습니다."),
    COSTUME_NOT_FOUND(404, "의상 관련 문제가 없습니다."),
    INTERNAL_SERVER_ERROR(500,"서버 에러");

    private int status;
    private String reason;
}