package com.GameOfLifeInitMouse;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.BowlingGame.Bowling_old;

import junit.framework.Assert;

public class TestGameOfLife {
Board gof;
	@Test
	public void testRule1() {
		//given
		gof=new Board(3,3);
				//when
		gof.initMatrixRandom();
		gof.getListOfCells().get(0).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(1).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(2).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(3).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(4).setCurrentState(LifeStatus.Life);//
		gof.getListOfCells().get(5).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(6).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(7).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(8).setCurrentState(LifeStatus.Dead);
		gof.nextGeneration();
		LifeStatus nextStat =gof.getListOfCells().get(4).getCurrentState();
				//then
		Assert.assertEquals(LifeStatus.Life, nextStat);

}
	@Test
	public void testRule2() {
		//given
		gof=new Board(3,3);
				//when
		gof.initMatrixRandom();
		gof.getListOfCells().get(0).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(1).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(2).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(3).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(4).setCurrentState(LifeStatus.Life);//
		gof.getListOfCells().get(5).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(6).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(7).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(8).setCurrentState(LifeStatus.Dead);
		gof.nextGeneration();
		LifeStatus nextStat =gof.getListOfCells().get(4).getCurrentState();
				//then
		Assert.assertEquals(LifeStatus.Dead, nextStat);

}
	@Test
	public void testRule3() {
		//given
		gof=new Board(3,3);
				//when
		gof.initMatrixRandom();
		gof.getListOfCells().get(0).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(1).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(2).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(3).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(4).setCurrentState(LifeStatus.Dead);//
		gof.getListOfCells().get(5).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(6).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(7).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(8).setCurrentState(LifeStatus.Dead);
		gof.nextGeneration();
		LifeStatus nextStat =gof.getListOfCells().get(4).getCurrentState();
				//then
		Assert.assertEquals(LifeStatus.Life, nextStat);

}
	@Test
	public void testRule4() {
		//given
		gof=new Board(3,3);
				//when
		gof.initMatrixRandom();
		gof.getListOfCells().get(0).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(1).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(2).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(3).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(4).setCurrentState(LifeStatus.Life);//
		gof.getListOfCells().get(5).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(6).setCurrentState(LifeStatus.Life);
		gof.getListOfCells().get(7).setCurrentState(LifeStatus.Dead);
		gof.getListOfCells().get(8).setCurrentState(LifeStatus.Dead);
		gof.nextGeneration();
		gof.nextGeneration();
		LifeStatus nextStat =gof.getListOfCells().get(4).getCurrentState();
				//then
		Assert.assertEquals(LifeStatus.Dead, nextStat);

}
}
