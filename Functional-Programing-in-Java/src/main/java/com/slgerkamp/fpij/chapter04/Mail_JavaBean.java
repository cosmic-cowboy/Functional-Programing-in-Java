package com.slgerkamp.fpij.chapter04;

/**
 * 4章 ラムダ式で設計する
 * 4.5 ラムダ式を使った流暢なインタフェース
 *
 */
public class Mail_JavaBean {

	private String from ;
	private String to ;
	private String subject ;
	private String body ;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
