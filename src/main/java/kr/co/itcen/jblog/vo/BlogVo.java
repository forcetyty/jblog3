package kr.co.itcen.jblog.vo;

public class BlogVo {

	private String id; // 회원 가입할때에 ID
	private String title; // 블로그 제목
	private String log; // 블로그 사진

	public String getBlog_id() {
		return id;
	}

	public void setBlog_id(String blog_id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

}
