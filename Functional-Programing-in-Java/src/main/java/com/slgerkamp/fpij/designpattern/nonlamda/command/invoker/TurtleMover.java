package com.slgerkamp.fpij.designpattern.nonlamda.command.invoker;

import java.util.HashMap;
import java.util.Map;

import com.slgerkamp.fpij.designpattern.nonlamda.command.command.Motion;
import com.slgerkamp.fpij.designpattern.nonlamda.command.receiver.Turtle;

/**
 * <p>亀の動きを制御する
 * <p>Invoker：登録されたコマンドオブジェクトを用いて動作を起動するクラス
 *
 */
public class TurtleMover {
	/** 文字と動作の対応. */
    private final Map<Character, Motion> motionMap = new HashMap<>();

    /** 文字に動作を割り当てる. */
    public void registerMotion(char ch, Motion motion) {
        this.motionMap.put(ch, motion);
    }

    /** 入力文字列に従って亀を動かす. */
    public void moveAround(Turtle turtle, String input) {
        for (char ch : input.toCharArray()) {
            Motion motion = this.motionMap.get(ch);
            if (motion != null) {
                motion.move(turtle);
            }
        }
    }
}
