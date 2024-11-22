package com.umc.spring.service.TempService;

import org.springframework.stereotype.Service;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.TempHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

	@Override
	public void CheckFlag(Integer flag) {
		if (flag == 1)
			throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
	}
}