package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
