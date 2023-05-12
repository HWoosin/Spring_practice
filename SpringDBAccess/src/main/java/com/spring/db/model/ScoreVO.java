package com.spring.db.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ScoreVO {
	
	private int stu_id;
	private String stu_name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double average;
	
	//총점과 평균을 구하는 메서드
	
	public void calcData() {
		this.total = this.kor + this.eng + this.math;
		this.average = Math.round((this.total/3.0)*100)/100.0;
	}
	

}



