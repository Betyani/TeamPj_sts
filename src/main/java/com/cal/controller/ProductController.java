package com.cal.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cal.dto.ProductDto;
import com.cal.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/product/*")
@RestController
public class ProductController {
	
	private ProductService service;
	
	@RequestMapping("/register")
	public void productRegister(@RequestBody ProductDto dto) {
		service.productRegister(dto);
		log.info("받아온 상품: " + dto);
	};
	
	@RequestMapping("/product")
	public ProductDto product(@RequestParam("id") int id) {
		ProductDto product = service.product(id);
		log.info("보낸 상품:" + product);
		return product;
	}
	
	@RequestMapping("/modify")
	public void productModify(@RequestBody ProductDto dto) {
		service.productModify(dto);
		log.info("수정된 상품" + dto);
	}
	
	@RequestMapping("/delete")
	public void productDelete(@RequestParam("id") int id) {
		service.productDelete(id);
		log.info("삭제할 상품id: " + id);
	}
	
}
