package com.slgerkamp.fpij.designpattern.lamda.observer;

import com.slgerkamp.fpij.designpattern.nonlamda.observer.subject.BackupJobDefinition;

/**
 * ジョブコントロール
 *
 */
public class LamdaJobController {

	public static void main(String[] args) {
		// バックアップジョブ定義
		BackupJobDefinition definition = new BackupJobDefinition();
		
		// オブザーバーを登録
		definition.addObserver(backupJob ->{
	        System.out.printf(
	        		"[INFO] バックアップ: %s ステータス: %s%n",
	        		backupJob.getFileName(), backupJob.getStatus());
		});
		String admin = "eva.lu.ator@example.org";
		definition.addObserver(backupJob -> {
			if(backupJob.isFinished()){
		        System.out.printf(
		        		"$ echo '%sへのバックアップ完了！' | mail -s 'バックアップ通知' %s%n",
		        		backupJob.getFileName(), admin);
				
			}			
		});
		// バックアップジョブ実行
		definition.execute();
	}
}
