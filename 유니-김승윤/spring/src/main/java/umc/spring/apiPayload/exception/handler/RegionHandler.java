package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    
    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
