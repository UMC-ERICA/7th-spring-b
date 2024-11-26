package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {

    public RestaurantHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
