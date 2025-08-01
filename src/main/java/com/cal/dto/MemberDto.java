package com.cal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Data
public class MemberDto {
	
	@NotBlank
	@Pattern(
		    regexp = "^[a-zA-Z0-9]{5,20}$",
		    message = "아이디는 영문자와 숫자로만 5~20자 입력 가능합니다."
		)
	private String id;
	
	@NotBlank
	@Pattern(
		    regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).{8,}$",
		    message = "비밀번호는 영문자, 숫자, 특수문자를 포함한 8자 이상이어야 합니다."
		)
	private String password;
	
	@NotBlank
	@Pattern(
		    regexp = "^[가-힣]+$",
		    message = "한글만 입력 가능합니다."
		)
	private String name;
	
	@NotBlank
	@Email(message = "올바른 이메일 형식을 입력해주세요.")
	private String email;
	
	@NotBlank
	@Pattern(
		    regexp = "^[가-힣a-zA-Z0-9]{2,10}$",
		    message = "닉네임은 한글, 영문, 숫자로 2~10자 이내여야 합니다."
		)
	private String nickname;
}
