package com.slgerkamp.fpij.designpattern.nonlamda.strategy.context;

import java.time.Instant;

import com.slgerkamp.fpij.designpattern.nonlamda.strategy.strategy.TimestampFormatter;

/**
 * <p>Contextの役割
 * <p>Strategyに基づいた動作を行う。
 * <p>ログを出力するクラス。
 *
 */
public class Logger {
	/** ロガーの名前. */
    private final String name;

    /** 時刻を文字列化するストラテジ. */
    private final TimestampFormatter formatter;

    public Logger(String name, TimestampFormatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    /** ログを出力する. */
    public void log(String message) {
        System.err.printf("%s [%s] %s%n", now(), this.name, message);
    }

    /** 現在時刻の文字列表現. */
    private String now() {
        return this.formatter.format(Instant.now());
    }

}
