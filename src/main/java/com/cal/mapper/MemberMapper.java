package com.cal.mapper;

import com.cal.dto.MemberDto;

public interface MemberMapper {
	public void signUp(MemberDto dto);
	public int checkId(String id);
	public int checkEmail(String email);
	public int checkNickname(String nickname);
}
