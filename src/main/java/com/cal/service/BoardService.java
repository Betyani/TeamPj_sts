package com.cal.service;

import java.util.List;

import com.cal.dto.BoardDto;
import com.cal.dto.ListDto;

public interface BoardService {
	public void boardRegister(BoardDto dto);
	public List<BoardDto> boardList(ListDto dto);
	public void boardModify(BoardDto dto);
	public BoardDto review(int id);
	public void boardDelete(int id);
	public int getTotalCount();
}
