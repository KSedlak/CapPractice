package com.capgemini.GameOfLifeInitMouse;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;



public class TestGameOfLife {
Board board;
	@Test
	public void testRule1() {
				//given
				board=new Board(3,3);
				GameLogic g= new GameLogic(board);
				ArrayList<Cell> test= new ArrayList<>();
				//when
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Life));//
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				board.setBoardMatrixFromFile(test);
				g.generateNeighboursList();
				g.nextGeneration();
		LifeStatus nextStat =board.getListOfCells().get(4).getCurrentState();
				//then
		Assert.assertEquals(LifeStatus.Life, nextStat);

}
	@Test
	public void testRule2() {
				//given
				board=new Board(3,3);
				GameLogic g= new GameLogic(board);
				ArrayList<Cell> test= new ArrayList<>();
				//when
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Life));//
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				board.setBoardMatrixFromFile(test);
				g.generateNeighboursList();
				g.nextGeneration();
		LifeStatus nextStat =board.getListOfCells().get(4).getCurrentState();
				//then
		Assert.assertEquals(LifeStatus.Dead, nextStat);

}
	@Test
	public void testRule3() {
				//given
				board=new Board(3,3);
				GameLogic g= new GameLogic(board);
				ArrayList<Cell> test= new ArrayList<>();
				//when
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Life));//
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				board.setBoardMatrixFromFile(test);
				g.generateNeighboursList();
				g.nextGeneration();
		LifeStatus nextStat =board.getListOfCells().get(4).getCurrentState();
				//then
		Assert.assertEquals(LifeStatus.Dead, nextStat);

}
	@Test
	public void testRule4() {
				//given
				board=new Board(3,3);
				GameLogic g= new GameLogic(board);
				ArrayList<Cell> test= new ArrayList<>();
				//when
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Dead));//
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Life));
				test.add(new Cell(LifeStatus.Dead));
				test.add(new Cell(LifeStatus.Dead));
				board.setBoardMatrixFromFile(test);
				g.generateNeighboursList();
				g.nextGeneration();
		LifeStatus nextStat =board.getListOfCells().get(4).getCurrentState();
				//then
		Assert.assertEquals(LifeStatus.Life, nextStat);

}

}
