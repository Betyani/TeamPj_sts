package com.cal.dto;

import lombok.Data;

@Data
public class ListDto {
	
	//produtList 페이징 처리용
	private int page;
	private int startIndex;
	private int pageSize = 8;
	private int totalCount;
	private int totalPage;
	private int blockSize = 5;
	private int startPage;
	private int endPage;
	private boolean hasPrev;
	private boolean hasNext;
	
	//boardList 상품 연결용
	private int productId;
	
	public void setTotalPage() {
		this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
	}
	
	public void setPage(int page) {
		this.page = page;
		this.startIndex = (page - 1) * pageSize;
		this.startPage = ((page - 1) / blockSize) * blockSize + 1 ;
		this.endPage = Math.min(startPage + blockSize - 1, totalPage);
		this.hasPrev = startPage > 1;
		this.hasNext = endPage < totalPage;
	}
	
	
}
