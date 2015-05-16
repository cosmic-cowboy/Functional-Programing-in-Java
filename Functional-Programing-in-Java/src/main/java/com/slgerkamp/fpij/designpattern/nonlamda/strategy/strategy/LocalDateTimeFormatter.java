package com.slgerkamp.fpij.designpattern.nonlamda.strategy.strategy;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * <p>Strategyの実装（ConcreteStrategy：具体的な計算を表す）
 * <p>時刻を「yyyy-MM-dd'T'HH:mm:ss.SSS」形式で文字列化
 *
 */
public class LocalDateTimeFormatter implements TimestampFormatter{

	/** タイムゾーン. */
    private final ZoneId zoneId;

    public LocalDateTimeFormatter(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public String format(Instant instant) {
        return LocalDateTime.ofInstant(instant, this.zoneId).toString();
    }
}
