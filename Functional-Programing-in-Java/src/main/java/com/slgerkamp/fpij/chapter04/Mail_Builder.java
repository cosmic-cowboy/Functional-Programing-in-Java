package com.slgerkamp.fpij.chapter04;

/**
 * 4章 ラムダ式で設計する
 * 4.5 ラムダ式を使った流暢なインタフェース
 *
 */
public class Mail_Builder {

	final String from ;
	final String to ;
	final String subject ;
	final String body ;

	/**
     * コンストラクタ
     * @param builder
     */
    private Mail_Builder(Builder builder) {

		this.from = builder.from;
		this.to = builder.to;
		this.subject = builder.subject;
		this.body = builder.body;
    }

	/**
	 * Mail_builderのビルダークラス
	 *
	 */
	static class Builder {
		private String from ;
		private String to ;
		private String subject ;
		private String body ;

        Builder() {}
	
        Builder from(String from){
        	this.from = from;
        	return this;
        }

        Builder to(String to){
        	this.to = to;
        	return this;
        }
        Builder subject(String subject){
        	this.subject = subject;
        	return this;
        }
        Builder body(String body){
        	this.body = body;
        	return this;
        }
        
        Mail_Builder build(){
        	return new Mail_Builder(this);
        }

	}
	
	
	
}
