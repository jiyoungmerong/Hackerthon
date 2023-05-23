package com.jiyoung.hakerton.exception;

import com.jiyoung.hakerton.domain.error.exception.CCException;
import com.jiyoung.hakerton.domain.error.exception.ErrorCode;

public class FoodNotFoundException extends CCException {

    public static final CCException EXCEPTION = new FoodNotFoundException();

    public FoodNotFoundException() {
        super(ErrorCode.FOOD_NOT_FOUND);
    }
}