package com.cal.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cal.dto.MemberDto;
import com.cal.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/member/*")
@RestController
public class MemberController {

	private MemberService service;

	// 회원가입
	@PostMapping("/signUp")
	public void signUp(@Valid @RequestBody MemberDto dto, BindingResult bindingResult) {
		
		//유효성 검사 실패시
		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors()
					.forEach(error -> log.info("유효성 오류 - " + error.getField() + ": " + error.getDefaultMessage()));
		}

		service.signUp(dto);
	}
}
