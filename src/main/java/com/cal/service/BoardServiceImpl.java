package com.cal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cal.dto.BoardDto;
import com.cal.dto.ListDto;
import com.cal.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	
	@Override
	public void boardRegister(BoardDto dto) {
		mapper.boardRegister(dto);
	}
	
	@Override
	public List<BoardDto> boardList(ListDto dto) {
		List<BoardDto> content = mapper.boardList(dto);
		return content;
	}

	@Override
	public void boardModify(BoardDto dto) {
		mapper.boardModify(dto);
	}
	
	@Override
	public BoardDto review(int id) {
		return mapper.review(id);
	}
	
	@Override
	public void boardDelete(int id) {
		mapper.boardDelete(id);
	}
	
	@Override
	public int getTotalCount() {
		return mapper.getTotalCount();
	}
	
}
