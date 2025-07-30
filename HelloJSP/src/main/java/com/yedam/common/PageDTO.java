package com.yedam.common;

import lombok.Data;

// 페이징정보
// 
@Data
public class PageDTO
{
	private int curPage;
	private int start, end; // 시작, 끝페이지
	private boolean prev, next; // 이전, 이후 페이지 체크
		
	public PageDTO(int page, int totalCnt) {
		curPage = page;
		end = (int)Math.ceil(page * 1.0 / 10) * 10;
		start = end - 9;
		
		// 실제 마지막페이지
		int realEnd = (int)Math.ceil(totalCnt * 1.0 / 5);
		end = end > realEnd ? realEnd : end;
		
		// 이전, 이후
		prev = start > 1;
		next = end < realEnd;
	}
}
