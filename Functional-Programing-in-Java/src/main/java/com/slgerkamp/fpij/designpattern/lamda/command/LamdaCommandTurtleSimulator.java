package com.slgerkamp.fpij.designpattern.lamda.command;

import com.slgerkamp.fpij.designpattern.nonlamda.command.invoker.TurtleMover;
import com.slgerkamp.fpij.designpattern.nonlamda.command.receiver.Turtle;

/**
 * <p>参照：http://codezine.jp/article/detail/8300
 *
 */
public class LamdaCommandTurtleSimulator {

	public static void main(String[] args) {
		
        String userInput = "↓←←↑↑→→→→↓↓";

        /*
         * 亀の動作を司る（登録されたコマンドオブジェクトを用いて動作を起動するInvoker）に
         * 亀の動作（動作を表すCommand）を登録する
         * commandはラムダ式で作成
         */
        TurtleMover turtleMover = new TurtleMover();
        turtleMover.registerMotion('←', t -> t.setX(t.getX() - 1));
        turtleMover.registerMotion('↓',  t -> t.setY(t.getY() - 1));
        turtleMover.registerMotion('↑',  t -> t.setY(t.getY() + 1));
        turtleMover.registerMotion('→',  t -> t.setX(t.getX() + 1));

		// 亀（動作の対象Receiver）を生成
        Turtle turtle = new Turtle(0, 0);

		// 亀を動作させる
        turtleMover.moveAround(turtle, userInput);

        // (5) 移動先を表示
        System.out.printf("X=%d Y=%d%n", turtle.getX(), turtle.getY());
		
		
	}
}
