package com.slgerkamp.fpij.designpattern.lamda.strategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.slgerkamp.fpij.designpattern.nonlamda.strategy.context.Logger;

/**
 * <p>クライアントの役割（ラムダ式対応）
 * <p>参照：http://codezine.jp/article/detail/8401
 *
 */
public class LamdaStrategyLoggerClient {
	public static void main(String[] args) {
		// 時刻をエポック時間で表示するロガー
	    Logger epochLogger = new Logger("epoch", instant -> {
	    	BigDecimal milli = BigDecimal.valueOf(instant.toEpochMilli());
	        BigDecimal sec = milli.divide(BigDecimal.valueOf(1000)).setScale(3);
	        return sec.toPlainString();
	    });
	    epochLogger.log("Hey!");
	    epochLogger.log("Ho!");
	    epochLogger.log("Let's go!");

	    // 日本時間のタイムゾーン
	    ZoneId jst = ZoneId.of("Asia/Tokyo");
	    // 時刻を日本時間で表示するロガー
	    Logger jstLogger = new Logger(
	    		"jst", 
	    		instant -> LocalDateTime.ofInstant(instant, jst).toString()
	    );
	    jstLogger.log("Hey!");
	    jstLogger.log("Ho!");
	    jstLogger.log("Let's go!");
		
	}
}
