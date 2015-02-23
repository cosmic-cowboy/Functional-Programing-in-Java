package com.slgerkamp.fpij.chapter04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.slgerkamp.fpij.chapter04.defaultMethod.SeaPlane;

/**
 * 4章 ラムダ式で設計する
 * 4.4 defaultメソッドを覗く
 */
public class DefaultMethodTest {

	@Test
	public void デフォルトメソッドテスト(){


		SeaPlane plane = new SeaPlane();

		assertThat(plane.takeoff(), is("FastFly::takeoff"));	
		assertThat(plane.turn(), is("Vehicle::turn"));	
		assertThat(plane.cruise(), is("Sail::cruise"));	
		assertThat(plane.land(), is("Fly::land"));	
	}

}
