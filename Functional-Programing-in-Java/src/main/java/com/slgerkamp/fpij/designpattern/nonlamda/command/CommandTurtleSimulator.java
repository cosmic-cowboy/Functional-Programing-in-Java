package com.slgerkamp.fpij.designpattern.nonlamda.command;

import com.slgerkamp.fpij.designpattern.nonlamda.command.command.DownMotion;
import com.slgerkamp.fpij.designpattern.nonlamda.command.command.LeftMotion;
import com.slgerkamp.fpij.designpattern.nonlamda.command.command.RightMotion;
import com.slgerkamp.fpij.designpattern.nonlamda.command.command.UpMotion;
import com.slgerkamp.fpij.designpattern.nonlamda.command.invoker.TurtleMover;
import com.slgerkamp.fpij.designpattern.nonlamda.command.receiver.Turtle;

public class CommandTurtleSimulator {

	public static void main(String[] args) {
		
        String userInput = "↓←←↑↑→→→→↓↓";

        /*
         * 亀の動作を司る（登録されたコマンドオブジェクトを用いて動作を起動するInvoker）に
         * 亀の動作（動作を表すCommand）を登録する
         */
        TurtleMover turtleMover = new TurtleMover();
        turtleMover.registerMotion('←', new LeftMotion());
        turtleMover.registerMotion('↓', new DownMotion());
        turtleMover.registerMotion('↑', new UpMotion());
        turtleMover.registerMotion('→', new RightMotion());

		// 亀（動作の対象Receiver）を生成
        Turtle turtle = new Turtle(0, 0);

		// 亀を動作させる
        turtleMover.moveAround(turtle, userInput);

        // (5) 移動先を表示
        System.out.printf("X=%d Y=%d%n", turtle.getX(), turtle.getY());
		
		
	}
}
