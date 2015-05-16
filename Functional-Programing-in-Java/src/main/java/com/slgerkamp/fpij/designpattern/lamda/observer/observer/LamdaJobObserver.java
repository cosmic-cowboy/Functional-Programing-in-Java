package com.slgerkamp.fpij.designpattern.lamda.observer.observer;

import com.slgerkamp.fpij.designpattern.nonlamda.observer.subject.Job;

/**
 * <p>ジョブ実行のオブザーバ (Observer)
 * <p>ラムダ式での実装を想定
 *
 * @param <J>
 */
@FunctionalInterface
public interface LamdaJobObserver<J extends Job> {
	void update(J job);
}
