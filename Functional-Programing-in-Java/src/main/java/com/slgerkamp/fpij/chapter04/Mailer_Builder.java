package com.slgerkamp.fpij.chapter04;


/**
 * 4章 ラムダ式で設計する
 * 4.5 ラムダ式を使った流暢なインタフェース
 * builderを２重にする意味がわからない。
 * ただ、メーラーでメールを生成する以上、メール自体は隠蔽する必要がある
 * ただ、メーラーは一通しかメールを送れないというのはおかしい。
 *
 */
public class Mailer_Builder {

	private final Mail_Builder.Builder mail_Builder;

	public Mailer_Builder() {
		super();
		this.mail_Builder = new Mail_Builder.Builder();
	}

	public void from(String from) {
		mail_Builder.from(from);
	}
	public void to(String to) {
		mail_Builder.to(to);
	}
	public void subject(String subject) {
		mail_Builder.subject(subject);
	}
	public void body(String body) {
		mail_Builder.body(body);
	}

	public Mail_Builder send(){
		return mail_Builder.build();
	}

}
