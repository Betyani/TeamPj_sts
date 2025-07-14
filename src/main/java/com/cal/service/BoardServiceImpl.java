package com.cal.service;

import org.springframework.stereotype.Service;

import com.cal.dto.BoardDto;
import com.cal.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	
	public void boardRegister(BoardDto dto) {
		mapper.boardRegister(dto);
		log.info("받아온 리뷰:" + dto);
	}
}
