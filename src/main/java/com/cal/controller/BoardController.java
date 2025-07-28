package com.cal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cal.dto.BoardDto;
import com.cal.dto.ListDto;
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
		log.info("쓴 리뷰: " + dto);
	}

	@RequestMapping("/list")
	public Map<String, Object> boardList(@RequestParam("productId") int productId,
			@RequestParam(defaultValue = "1", value = "page") int page) {
		ListDto dto = new ListDto();
		dto.setProductId(productId);
		int totalCount = service.getTotalCount();
		dto.setTotalCount(totalCount);
		dto.setTotalPage();
		dto.setPage(page);
		
		List<BoardDto> reviews = service.boardList(dto);
		log.info("받아온 리뷰: " + reviews);
		Map<String, Object> result = new HashMap<>();
		result.put("reviews", reviews);
		result.put("pageInfo", dto);
		
		return result;
	}

	@RequestMapping("/modify")
	public void boardModify(@RequestBody BoardDto dto) {
		service.boardModify(dto);
		log.info("수정된 내용: " + dto);
	}

	@RequestMapping("/review")
	public BoardDto review(int id) {
		BoardDto review = service.review(id);
		log.info("받아온 리뷰: " + review);
		return review;
	}

	@RequestMapping("/delete")
	public void boardDelete(@RequestParam("id") int id) {
		service.boardDelete(id);
		log.info("삭제할 리뷰 번호: " + id);
	}

}
