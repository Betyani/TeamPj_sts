package com.cal.service;

import org.springframework.stereotype.Service;

import com.cal.dto.MemberDto;
import com.cal.mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;
	
	@Override
	public void signUp(MemberDto dto) {
		mapper.signUp(dto);
	}
}
