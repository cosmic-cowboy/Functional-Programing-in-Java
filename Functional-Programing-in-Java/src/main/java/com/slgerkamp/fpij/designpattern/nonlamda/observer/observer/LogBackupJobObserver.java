package com.slgerkamp.fpij.designpattern.nonlamda.observer.observer;

import com.slgerkamp.fpij.designpattern.nonlamda.observer.subject.BackupJob;

/**
 * <p>バックアップの完了をログ出力するオブザーバー
 *
 */
public class LogBackupJobObserver implements JobObserver<BackupJob>{

	@Override
	public void update(BackupJob job) {
        System.out.printf(
        		"[INFO] バックアップ: %s ステータス: %s%n",
                job.getFileName(), job.getStatus());
	}

}
