package com.spring.db.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	
	private int boardNo;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime regDate;
	
}
