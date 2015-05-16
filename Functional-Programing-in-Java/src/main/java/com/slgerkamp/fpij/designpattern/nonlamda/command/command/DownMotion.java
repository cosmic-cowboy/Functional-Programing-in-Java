package com.slgerkamp.fpij.designpattern.nonlamda.command.command;

import com.slgerkamp.fpij.designpattern.nonlamda.command.receiver.Turtle;

/**
 * <p>参照：http://codezine.jp/article/detail/8300
 *
 */
public class DownMotion implements Motion{

	@Override
	public void move(Turtle turtle) {
		turtle.setY(turtle.getY() + 1);
	}

}
