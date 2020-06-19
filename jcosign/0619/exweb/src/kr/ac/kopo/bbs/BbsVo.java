package kr.ac.kopo.bbs;

import java.util.Date;

public class BbsVo {
	private int bbsNo;	
	private String bbsTitle;	
	private String bbsContent;	
	private String bbsWriter;
	private Date bbsRegDate;
	private int bbsCount;
	
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsWriter() {
		return bbsWriter;
	}
	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}
	public Date getBbsRegDate() {
		return bbsRegDate;
	}
	public void setBbsRegDate(Date bbsRegDate) {
		this.bbsRegDate = bbsRegDate;
	}
	public int getBbsCount() {
		return bbsCount;
	}
	public void setBbsCount(int bbsCount) {
		this.bbsCount = bbsCount;
	}

}



//bbs_no, bbs_title, bbs_content, bbs_writer, bbs_reg_date, bbs_count
	/*			vo.setBbsNo( rs.getInt("bbs_no"));
				vo.setBbsTitle( rs.getString("bbs_title"));
				vo.setBbsContent( rs.getString("bbs_content"));
				vo.setBbsWriter( rs.getString("bbs_writer"));
				vo.setBbsRegDate( rs.getString("bbs_reg_date"));
				vo.setBbsCount( rs.getInt("bbs_count"));
	*/
