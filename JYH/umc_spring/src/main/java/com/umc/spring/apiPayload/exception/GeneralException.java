package com.umc.spring.apiPayload.exception;

import com.umc.spring.apiPayload.code.BaseErrorCode;
import com.umc.spring.apiPayload.code.ErrorReasonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

	private BaseErrorCode code;

	public ErrorReasonDTO getErrorReason() {
		return this.code.getReason();
	}

	public ErrorReasonDTO getErrorReasonHttpStatus(){
		return this.code.getReasonHttpStatus();
	}
}