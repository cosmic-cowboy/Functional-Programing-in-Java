package com.slgerkamp.fpij.designpattern.nonlamda.strategy.strategy;

import java.time.Instant;

/**
 * <p>Strategyの役割
 * <p>時刻を文字列化するストラテジのインタフェース
 *
 */
public interface TimestampFormatter {

	String format(Instant instant);

}
