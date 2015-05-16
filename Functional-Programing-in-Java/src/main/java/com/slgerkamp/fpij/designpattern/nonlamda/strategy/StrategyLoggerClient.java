package com.slgerkamp.fpij.designpattern.nonlamda.strategy;

import java.time.ZoneId;

import com.slgerkamp.fpij.designpattern.nonlamda.strategy.context.Logger;
import com.slgerkamp.fpij.designpattern.nonlamda.strategy.strategy.EpochFormatter;
import com.slgerkamp.fpij.designpattern.nonlamda.strategy.strategy.LocalDateTimeFormatter;

/**
 * <p>クライアントの役割
 *
 */
public class StrategyLoggerClient {
	public static void main(String[] args) {
		// 時刻をエポック時間で表示するロガー
	    Logger epochLogger = new Logger("epoch", new EpochFormatter());
	    epochLogger.log("Hey!");
	    epochLogger.log("Ho!");
	    epochLogger.log("Let's go!");

	    // 日本時間のタイムゾーン
	    ZoneId jst = ZoneId.of("Asia/Tokyo");
	    // 時刻を日本時間で表示するロガー
	    Logger jstLogger = new Logger("jst", new LocalDateTimeFormatter(jst));
	    jstLogger.log("Hey!");
	    jstLogger.log("Ho!");
	    jstLogger.log("Let's go!");
		
	}
}
