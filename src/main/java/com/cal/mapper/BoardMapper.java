package com.cal.mapper;

import java.util.List;

import com.cal.dto.BoardDto;

public interface BoardMapper {
	public void boardRegister(BoardDto dto);
	public List<BoardDto> boardList(int productId);
	public void boardModify(BoardDto dto);
	public BoardDto review(int id);
}
