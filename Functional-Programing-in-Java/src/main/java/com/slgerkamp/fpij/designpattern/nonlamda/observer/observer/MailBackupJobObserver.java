package com.slgerkamp.fpij.designpattern.nonlamda.observer.observer;

import com.slgerkamp.fpij.designpattern.nonlamda.observer.subject.BackupJob;

/**
 * <p>バックアップの完了をメール通知するオブザーバー
 *
 */
public class MailBackupJobObserver implements JobObserver<BackupJob>{

	/** 通知先メールアドレス. */
    private final String mailAddress;

    public MailBackupJobObserver(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    
	@Override
	public void update(BackupJob job) {
		if(job.isFinished()){
	        System.out.printf(
	        		"$ echo '%sへのバックアップ完了！' | mail -s 'バックアップ通知' %s%n",
	                job.getFileName(), this.mailAddress);
			
		}
	}

}
