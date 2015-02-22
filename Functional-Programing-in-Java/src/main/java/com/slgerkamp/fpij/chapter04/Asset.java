package com.slgerkamp.fpij.chapter04;

/**
 * 4章-1 ラムダ式を使った関心の分離
 * 
 * 資産クラス
 *
 */
public class Asset {

	public enum AssetType {BOND, STOCK};
	
	// Getterやめたいけど
	// メソッド参照で使うので
	private final AssetType type;
	private final int value;
	
	public Asset(AssetType type, int value) {
		this.type = type;
		this.value = value;
	}

	public AssetType getType() {
		return type;
	}

	public int getValue() {
		return value;
	}
}
