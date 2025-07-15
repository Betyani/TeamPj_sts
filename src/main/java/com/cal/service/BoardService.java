package com.cal.service;

import java.util.List;

import com.cal.dto.BoardDto;

public interface BoardService {
	public void boardRegister(BoardDto dto);
	public List<BoardDto> boardList(int productId);
}
