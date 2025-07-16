package com.cal.service;

import java.util.List;

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
	
	@Override
	public void boardRegister(BoardDto dto) {
		mapper.boardRegister(dto);
		log.info("받아온 리뷰:" + dto);
	}
	
	@Override
	public List<BoardDto> boardList(int productId) {
		List<BoardDto> content = mapper.boardList(productId);
		log.info("받아온 상품 번호" + productId);
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
	
}
