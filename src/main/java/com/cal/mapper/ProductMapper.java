package com.cal.mapper;

import java.util.ArrayList;

import com.cal.dto.ProductDto;

public interface ProductMapper {
	public void productRegister(ProductDto dto);
	public ProductDto product(int id);
	public void productModify(ProductDto dto);
	public void productDelete(int id);
	public ArrayList<ProductDto> productList();
}
