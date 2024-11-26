package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class CategoryHandler extends GeneralException {

    public CategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
