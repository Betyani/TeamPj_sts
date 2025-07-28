package com.cal.dto;

import lombok.Data;

@Data
public class ListDto {
	private int page;
	private int startIndex;
	private int listAmount = 8;
	private int totalCount;
	
	public void setPage(int page) {
		this.page = page;
		this.startIndex = (page - 1) * this.listAmount;
	}
	
	public int getTotalPage() {
		return (int) Math.ceil((double) totalCount / listAmount);
	}
	
}
