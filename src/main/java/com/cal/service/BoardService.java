package com.cal.service;

import java.util.List;

import com.cal.dto.BoardDto;

public interface BoardService {
	public void boardRegister(BoardDto dto);
	public List<BoardDto> boardList(int productId);
	public void boardModify(BoardDto dto);
	public BoardDto review(int id);
	public void boardDelete(int id);
}
