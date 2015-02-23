package com.slgerkamp.fpij.chapter04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;

import org.junit.Test;

/**
 * 4章 ラムダ式で設計する
 * 4.5 ラムダ式を使った流暢なインタフェース
 *
 */
public class MailerTest {

	private static final String FROMADRESS = "build@agiledeveloper.com";
	private static final String TOADRESS   = "venkats@agiledeveloper.com";
	private static final String SUBJECT = "build notification";
	private static final String BODY = "your code is ...";
	
	@Test
	public void セッターを使ってメールを作成する(){

		// 本来こんな形では生成しない
		// 少なくともbuilderを使う
		Mailer_JavaBean mailer = new Mailer_JavaBean();
		mailer.from(FROMADRESS);
		mailer.to(TOADRESS);
		mailer.subject(SUBJECT);
		mailer.body(BODY);
		Mail_JavaBean mail = mailer.send();
		
		assertThat(mail.getFrom(),    is(FROMADRESS));	
		assertThat(mail.getTo(),      is(TOADRESS));	
		assertThat(mail.getSubject(), is(SUBJECT));	
		assertThat(mail.getBody(),    is(BODY));	
	}



}
