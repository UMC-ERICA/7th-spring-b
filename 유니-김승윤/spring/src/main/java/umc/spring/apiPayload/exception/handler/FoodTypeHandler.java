package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class FoodTypeHandler extends GeneralException {
    public FoodTypeHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
