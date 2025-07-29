package com.yedam.common;

import lombok.Data;

// 페이징정보
// 
@Data
public class PageDTO
{
	private int curPage;
	private int start, end; // 시작, 끝페이지
	
	public PageDTO(int page, int totalCnt) {
		curPage = page;
		end = (int)Math.ceil(page * 1.0 / 10) * 10;
		start = end - 9;
		
	}
}
