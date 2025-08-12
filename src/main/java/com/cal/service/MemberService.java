package com.cal.service;

import com.cal.dto.MemberDto;

public interface MemberService {
	public void signUp(MemberDto dto);
	public boolean checkId(String id);
	public boolean checkEmail(String email);
	public boolean checkNickname(String nickname);
}
