package com.slgerkamp.fpij.designpattern.nonlamda.observer.subject;

/**
 * <p>バックアップジョブ
 * <p>ジョブの実行部分のみ実装
 */
public class BackupJob extends Job{

    /** バックアップファイルの名前. */
    private final String fileName;

    public BackupJob(String fileName) {
        this.fileName = fileName;
    }

    /** バックアップファイルの名前を戻す. */
    public String getFileName() {
        return this.fileName;
    }

	@Override
	public void run() {
		System.out.printf("$ pg_dumpall >%s%n", this.fileName);
	}

}
