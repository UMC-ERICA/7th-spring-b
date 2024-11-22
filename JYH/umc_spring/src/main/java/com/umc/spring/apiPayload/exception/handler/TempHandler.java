package com.umc.spring.apiPayload.exception.handler;

import com.umc.spring.apiPayload.code.BaseErrorCode;
import com.umc.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

	public TempHandler(BaseErrorCode errorCode) {
		super(errorCode);
	}
}
