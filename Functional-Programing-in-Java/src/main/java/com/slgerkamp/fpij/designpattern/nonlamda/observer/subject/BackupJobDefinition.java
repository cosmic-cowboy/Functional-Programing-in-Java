package com.slgerkamp.fpij.designpattern.nonlamda.observer.subject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BackupJobDefinition extends JobDefinition<BackupJob>{

	/** バックアップファイル名のフォーマッタ. */
    private static final DateTimeFormatter FILE_NAME_FORMATTER
        = DateTimeFormatter.ofPattern("'/backup/'yyyy_MM_dd'.sql'");

	@Override
	protected BackupJob makeJob() {
        LocalDate startDate = LocalDate.now();
        String fileName = startDate.format(FILE_NAME_FORMATTER);
        return new BackupJob(fileName);
	}

}
