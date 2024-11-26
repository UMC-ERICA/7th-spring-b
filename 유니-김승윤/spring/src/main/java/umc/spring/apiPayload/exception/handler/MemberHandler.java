package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
