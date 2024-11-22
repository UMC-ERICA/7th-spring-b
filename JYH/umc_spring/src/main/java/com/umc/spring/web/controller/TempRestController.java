package com.umc.spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.converter.TempConverter;
import com.umc.spring.service.TempService.TempQueryService;
import com.umc.spring.web.dto.TempResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

	private final TempQueryService tempQueryService;

	@GetMapping("/test")
	public ApiResponse<TempResponse.TempTestDTO> testAPI() {

		return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
	}

	@GetMapping("/exception")
	public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam("flag") Integer flag){
		tempQueryService.CheckFlag(flag);
		return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
	}
}
