package com.slgerkamp.fpij.designpattern.nonlamda.command.receiver;

/**
 * <p>亀（位置を表す）
 * <p>Receiver：動作の対象となるオブジェクトのクラスあるいはインタフェース
 *
 */
public class Turtle {
	
	private int x, y;
	
    public Turtle(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
