package com.capgemini.BowlingGame;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestBowling {
Bowling bowl;
	@Test
	public void testSingleThrowNotStrike() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(7);
		//then
	Assert.assertEquals(7, bowl.score());
	}
	@Test
	public void testTwiceThrowSpare() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(7);
		bowl.roll(3);
		//then
	Assert.assertEquals(10, bowl.score());

	}
	@Test
	public void testTwiceThrowSpareAndNext() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(7);
		bowl.roll(3);
		bowl.roll(8);
		//then
	Assert.assertEquals(26, bowl.score());

	}
	@Test
	public void testTripleStrike() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(10);
		bowl.roll(10);
		bowl.roll(10);
		bowl.roll(8);
		bowl.roll(1);
		//then
	Assert.assertEquals(86, bowl.score());

	}
	
	@Test
	public void testTwiceNothing() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(0);
		bowl.roll(0);
		//then
	Assert.assertEquals(0, bowl.score());

	}
	@Test
	public void testOnceStrike() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(10);
		bowl.roll(5);
		bowl.roll(1);
		//then
	Assert.assertEquals(22, bowl.score());

	}
	@Test
	public void testTwicetrike() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(10);
		bowl.roll(10);
		bowl.roll(5);
		bowl.roll(0);
		//then
	Assert.assertEquals(45, bowl.score());

	}
	@Test
	public void testSpareInTheMiddle() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(10);//1
		bowl.roll(10);//2
		bowl.roll(10);//3
		bowl.roll(5);//4
		bowl.roll(5);//4
		bowl.roll(10);//5
		bowl.roll(10);//6
		bowl.roll(10);//7
		bowl.roll(10);//8
		bowl.roll(10);//9
		bowl.roll(10);//10
		bowl.roll(10);
		bowl.roll(10);
		
	
		//then
	Assert.assertEquals(275, bowl.score());

	}
	@Test
	public void testIsFinishedAndMaxScore() {
		//given
		bowl=new Bowling();
		//when
		bowl.roll(10);//1
		bowl.roll(10);//2
		bowl.roll(10);//3
		bowl.roll(10);//4
		bowl.roll(10);//5
		bowl.roll(10);//6
		bowl.roll(10);//7
		bowl.roll(10);//8
		bowl.roll(10);//9
		bowl.roll(10);//10
		bowl.roll(10);
		boolean end=bowl.isFinished();
		bowl.roll(10);
	
	
		//then
	Assert.assertEquals(false, end);
	Assert.assertEquals(300, bowl.score());

	}

}
