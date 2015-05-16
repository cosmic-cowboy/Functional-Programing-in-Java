package com.slgerkamp.fpij.designpattern.nonlamda.command.command;

import com.slgerkamp.fpij.designpattern.nonlamda.command.receiver.Turtle;

public class DownMotion implements Motion{

	@Override
	public void move(Turtle turtle) {
		turtle.setY(turtle.getY() + 1);
	}

}
