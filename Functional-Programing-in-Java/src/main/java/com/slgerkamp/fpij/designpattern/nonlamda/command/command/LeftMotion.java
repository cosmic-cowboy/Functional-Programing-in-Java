package com.slgerkamp.fpij.designpattern.nonlamda.command.command;

import com.slgerkamp.fpij.designpattern.nonlamda.command.receiver.Turtle;

public class LeftMotion implements Motion{

	@Override
	public void move(Turtle turtle) {
		turtle.setX(turtle.getX() - 1);
	}

}
