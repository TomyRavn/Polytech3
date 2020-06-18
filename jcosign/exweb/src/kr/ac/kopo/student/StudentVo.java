package kr.ac.kopo.student;


public class StudentVo {
	private String stuNo;
	private String stuName;
	private int stuScore;

	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuScore() {
		return stuScore;
	}
	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}

}






////일반적으로 데이터베이스 테이블의 레코드(row) 1개를 저장할 수 있는 vo클래스를 정의
//public class StudentVo {
//	private String stuNo;
//	private String stuName;
//	private int stuScore;
