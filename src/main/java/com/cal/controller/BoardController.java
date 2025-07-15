package com.cal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cal.dto.BoardDto;
import com.cal.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
@RestController
public class BoardController {
	
	private BoardService service;
	
	
	@RequestMapping("/register")
	public void boardRegister(@RequestBody BoardDto dto) {
		service.boardRegister(dto);
	}
	
	@RequestMapping("/list")
	public List<BoardDto> boardList(@RequestParam("productid") int productId){
		List<BoardDto> content = service.boardList(productId);
		log.info("받아온 리뷰: " + content);
		return content;
	}
	
	
}
