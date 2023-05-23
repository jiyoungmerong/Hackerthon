package com.jiyoung.hakerton.exception;

import com.jiyoung.hakerton.domain.error.exception.CCException;
import com.jiyoung.hakerton.domain.error.exception.ErrorCode;

public class FlagNotFoundException extends CCException {

    public static final CCException EXCEPTION = new FlagNotFoundException();

    public FlagNotFoundException() {
        super(ErrorCode.FLAG_NOT_FOUND);
    }
}