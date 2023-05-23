package com.jiyoung.hakerton.exception;

import com.jiyoung.hakerton.domain.error.exception.CCException;
import com.jiyoung.hakerton.domain.error.exception.ErrorCode;

public class CostumeNotFoundException extends CCException {

    public static final CCException EXCEPTION = new CostumeNotFoundException();

    public CostumeNotFoundException() {
        super(ErrorCode.COSTUME_NOT_FOUND);
    }
}