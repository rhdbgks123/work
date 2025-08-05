package com.yedam.vo;

import java.util.Date;

import lombok.Data;

//board_no    number, -- 게시글번호
//title       varchar2(100) not null, -- 제목
//content     varchar2(3000) not null, -- 내용
//writer      varchar2(30) not null, -- 작성자
//view_cnt    number default 0, -- 조회수
//create_date date default sysdate, -- 생성일시
//update_date date default sysdate -- 변경일시

@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private Date createDate;
	private Date updateDate;
	private String image;
}
