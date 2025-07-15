package com.cal.service;

import java.util.List;

import com.cal.dto.ProductDto;

public interface ProductService {
	public void productRegister(ProductDto dto);
	public ProductDto product(int id);
	public void productModify(ProductDto dto);
	public void productDelete(int id);
	public List<ProductDto> productList();
}
