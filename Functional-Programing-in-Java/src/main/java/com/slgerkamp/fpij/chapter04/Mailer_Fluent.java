package com.slgerkamp.fpij.chapter04;

import java.util.function.Consumer;


/**
 * 4章 ラムダ式で設計する
 * 4.5 ラムダ式を使った流暢なインタフェース
 * 
 * そもそも前提がおかしくて、
 * Decoratorパターンではない。
 *
 */
public class Mailer_Fluent {

	private final Mail_JavaBean mail;

	public Mailer_Fluent() {
		mail = new Mail_JavaBean();
	}

	public Mailer_Fluent from(String from) {
		mail.setFrom(from);
		return this;
	}
	public Mailer_Fluent to(String to) {
		mail.setTo(to);
		return this;
	}
	public Mailer_Fluent subject(String subject) {
		mail.setSubject(subject);
		return this;
	}
	public Mailer_Fluent body(String body) {
		mail.setBody(body);
		return this;
	}

	public static Mail_JavaBean send(final Consumer<Mailer_Fluent> block){
		final Mailer_Fluent mailer = new Mailer_Fluent();
		block.accept(mailer);
		return mailer.mail;
	}

}
