package com.jiyoung.hakerton.exception;

import com.jiyoung.hakerton.domain.error.exception.CCException;
import com.jiyoung.hakerton.domain.error.exception.ErrorCode;

public class LandmarkNotFoundException extends CCException {

    public static final CCException EXCEPTION = new LandmarkNotFoundException();

    public LandmarkNotFoundException() {
        super(ErrorCode.FOOD_NOT_FOUND);
    }
}