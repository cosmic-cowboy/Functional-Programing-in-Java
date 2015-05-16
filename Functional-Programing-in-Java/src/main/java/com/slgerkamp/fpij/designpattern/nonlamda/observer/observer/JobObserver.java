package com.slgerkamp.fpij.designpattern.nonlamda.observer.observer;

import com.slgerkamp.fpij.designpattern.nonlamda.observer.subject.Job;

/**
 * <p>ジョブ実行のオブザーバ (Observer)
 */
public interface JobObserver<J extends Job> {
    void update(J job);
}