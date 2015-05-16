package com.slgerkamp.fpij.designpattern.nonlamda.strategy.strategy;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * <p>Strategyの実装
 * <p>時刻をエポック時間で文字列化
 *
 */
public class EpochFormatter implements TimestampFormatter{

	@Override
    public String format(Instant instant) {
        BigDecimal milli = BigDecimal.valueOf(instant.toEpochMilli());
        BigDecimal sec = milli.divide(BigDecimal.valueOf(1000)).setScale(3);
        return sec.toPlainString();
    }
}
