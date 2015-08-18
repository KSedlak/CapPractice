package com.capgemini.GameOfLifeWithoutMouse;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.BowlingGame.Bowling_old;

import junit.framework.Assert;

public class TestGameOfLife {
GameOfLife gof;
	@Test
	public void testRule1() {
		//given
		gof=new GameOfLife(3,3);
				//when
		gof.initMatrix();
		gof.listOfCells.get(4).setLifeStatus(true);
		gof.listOfCells.get(4).setNeighboursValue(1);
		gof.nextGeneration();
		boolean nextStat =gof.listOfCells.get(4).getLifeStatus();
				//then
		Assert.assertEquals(false, nextStat);

}
	@Test
	public void testRule2() {
		//given
		gof=new GameOfLife(3,3);
				//when
		gof.initMatrix();
		gof.listOfCells.get(4).setLifeStatus(true);
		gof.listOfCells.get(4).setNeighboursValue(2);
		gof.nextGeneration();
		boolean nextStat =gof.listOfCells.get(4).getLifeStatus();
				//then
		Assert.assertEquals(true, nextStat);

}
	@Test
	public void testRule3() {
		//given
		gof=new GameOfLife(3,3);
				//when
		gof.initMatrix();
		gof.listOfCells.get(4).setLifeStatus(true);
		gof.listOfCells.get(4).setNeighboursValue(4);
		gof.nextGeneration();
		boolean nextStat =gof.listOfCells.get(4).getLifeStatus();
				//then
		Assert.assertEquals(false, nextStat);

}
	@Test
	public void testRule4() {
		//given
		gof=new GameOfLife(3,3);
				//when
		gof.initMatrix();
		gof.listOfCells.get(4).setLifeStatus(false);
		gof.listOfCells.get(4).setNeighboursValue(3);
		gof.nextGeneration();
		boolean nextStat =gof.listOfCells.get(4).getLifeStatus();
				//then
		Assert.assertEquals(true, nextStat);

}
}
