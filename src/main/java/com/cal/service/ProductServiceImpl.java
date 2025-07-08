package com.cal.service;

import org.springframework.stereotype.Service;

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

}
