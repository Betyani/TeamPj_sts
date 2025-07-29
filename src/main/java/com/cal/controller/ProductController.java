package com.cal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cal.dto.ListDto;
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

//	상품 등록(React에서 받아온 json 데이터를 dto에 저장) 
	@PostMapping("/register")
	public void productRegister(@RequestBody ProductDto dto) {
		service.productRegister(dto);
		log.info("받아온 상품: " + dto);
	};

//	상품 1개 조회(React에서 id 파라미터 값을 받아와서 id값에 저장, id값에 해당하는 상품을 product에 저장해 다시 React로 리턴)
	@GetMapping("/product")
	public ProductDto product(@RequestParam("id") int id) {
		ProductDto product = service.product(id);
		log.info("보낸 상품:" + product);
		return product;
	}

//	상품 수정(React에서 받아온 json 데이터를 dto에 저장)
	@PostMapping("/modify")
	public void productModify(@RequestBody ProductDto dto) {
		service.productModify(dto);
		log.info("수정된 상품" + dto);
	}

// 상품 삭제
	@DeleteMapping("/delete")
	public void productDelete(@RequestParam("id") int id) {
		service.productDelete(id);
		log.info("삭제할 상품id: " + id);
	}

// 상품 조회	
	@GetMapping("/list")
	public Map<String, Object> productList(@RequestParam(defaultValue = "1", value = "page") int page,
			@RequestParam(required = false, value = "category") String category,
			@RequestParam(required = false, value = "keyword") String keyword,
			@RequestParam(defaultValue = "true", value = "desc") boolean desc) {
		
		//페이징 및 정렬 처리용
		ListDto dto = new ListDto();
		dto.setCategory(category);
		dto.setKeyword(keyword);
		dto.setDesc(desc);
		
		int totalCount = service.getTotalCount(dto);		
		dto.setTotalCount(totalCount);
		dto.setTotalPage();
		dto.setPage(page);
		
		//상품 불러오기
		List<ProductDto> products = service.productList(dto);
		log.info(products);
		Map<String, Object> result = new HashMap<>();
		result.put("products", products);
		result.put("pageInfo", dto);

		return result;
	}

}
