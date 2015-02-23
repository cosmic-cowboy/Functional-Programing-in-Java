package com.slgerkamp.fpij.chapter04;

/**
 * 4章 ラムダ式で設計する
 * 4.5 ラムダ式を使った流暢なインタフェース
 *
 */
public class Mailer_JavaBean {

	private final Mail_JavaBean mail;

	public Mailer_JavaBean() {
		super();
		this.mail = new Mail_JavaBean();
	}

	public void from(String from) {
		mail.setFrom(from);
	}
	public void to(String to) {
		mail.setTo(to);
	}
	public void subject(String subject) {
		mail.setSubject(subject);
	}
	public void body(String body) {
		mail.setBody(body);
	}

	public Mail_JavaBean send(){
		return mail;
	}
}
