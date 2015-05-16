package com.slgerkamp.fpij.designpattern.nonlamda.observer;

import com.slgerkamp.fpij.designpattern.nonlamda.observer.observer.LogBackupJobObserver;
import com.slgerkamp.fpij.designpattern.nonlamda.observer.observer.MailBackupJobObserver;
import com.slgerkamp.fpij.designpattern.nonlamda.observer.subject.BackupJobDefinition;

/**
 * ジョブコントロール
 *
 */
public class JobController {

	public static void main(String[] args) {
		// バックアップジョブ定義
		BackupJobDefinition definition = new BackupJobDefinition();
		
		// オブザーバーを登録
		definition.addObserver(new LogBackupJobObserver());
		String admin = "eva.lu.ator@example.org";
		definition.addObserver(new MailBackupJobObserver(admin));
		// バックアップジョブ実行
		definition.execute();
	}
}
