package com.slgerkamp.fpij.designpattern.nonlamda.command.command;

import com.slgerkamp.fpij.designpattern.nonlamda.command.receiver.Turtle;

/**
 * <p>参照：http://codezine.jp/article/detail/8300
 * <p>亀の動きのインタフェース
 * <p>Command：動作を表すコマンドオブジェクトのインタフェース
 *
 */
public interface Motion {
	public void move(Turtle turtle);
}
