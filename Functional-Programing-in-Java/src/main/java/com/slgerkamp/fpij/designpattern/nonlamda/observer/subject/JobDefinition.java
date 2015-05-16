package com.slgerkamp.fpij.designpattern.nonlamda.observer.subject;

import java.util.ArrayList;
import java.util.List;

import com.slgerkamp.fpij.designpattern.nonlamda.observer.observer.JobObserver;

public abstract class JobDefinition<J extends Job> {

    /** オブザーバ一式. */
    private final List<JobObserver<? super J>> observers = new ArrayList<>();

    /** オブザーバを登録. */
    public void addObserver(JobObserver<? super J> observer) {
        this.observers.add(observer);
    }

    /** ジョブを作成、実行. */
    public final void execute() {
        J job = makeJob();
        notifyObservers(job);
        job.execute();
        notifyObservers(job);
    }

    /** オブザーバにジョブの状態を通知. */
    private void notifyObservers(J job) {
        for (JobObserver<? super J> observer : this.observers) {
            observer.update(job);
        }
    }

    /** ジョブを作成するファクトリメソッド. */
    abstract protected J makeJob();
}
