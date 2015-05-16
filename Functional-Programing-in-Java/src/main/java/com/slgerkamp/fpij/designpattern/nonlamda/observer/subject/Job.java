package com.slgerkamp.fpij.designpattern.nonlamda.observer.subject;

/**
 * <p>ジョブの抽象クラス
 * <p>Subjectの役割の一部を担い、状態の保持と変更を担う
 */
public abstract class Job {

    /** ジョブの状態. */
	public enum Status { 
    	UNFINISHED, 
    	FINISHED 
    }

    /** ジョブの状態. */
    private Status status;

    public Job() {
        this.status = Status.UNFINISHED;
    }

    /** ジョブの状態を戻す. */
    public final Status getStatus() {
        return this.status;
    }

    /** ジョブが完了していたらtrueを戻す. */
    public final boolean isFinished() {
        return this.status == Status.FINISHED;
    }

    /** ジョブを実行. */
    public final void execute() {
        run();
        this.status = Status.FINISHED;
    }

    /** ジョブの処理の内容を実装. */
    public abstract void run();
}