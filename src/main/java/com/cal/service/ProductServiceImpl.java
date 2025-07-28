package com.cal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cal.dto.ListDto;
import com.cal.dto.ProductDto;
import com.cal.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductMapper mapper;
	
	@Override
	public void productRegister(ProductDto dto) {
		mapper.productRegister(dto);
	};
	
	@Override
	public ProductDto product(int id) {
		return mapper.product(id);
	}

	@Override
	public void productModify(ProductDto dto) {
		mapper.productModify(dto);
	}

	@Override
	public void productDelete(int id) {
		mapper.productDelete(id);
	}
	
	@Override
	public int getTotalCount() {
		return mapper.getTotalCount();
	}
	
	
	@Override
	public List<ProductDto> productList(ListDto dto) {
		return mapper.productList(dto);
	}
	
}
