package kr.ac.kopo.bookshop.util;

public class Pager {
	int page = 1;		//default 값을 1로 정해주면 따로 안정해져 있을 시 spring이 뒤져서 자동으로 해당 값으로 세팅해줌
	int perPage = 10;
	float total;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
}