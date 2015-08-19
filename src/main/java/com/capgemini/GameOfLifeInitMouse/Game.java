package com.capgemini.GameOfLifeInitMouse;

public class Game {

	public static void main(String[] args) {
		Board board= new Board(10, 10);
		board.initPositionsForMatrix();
		GameLogic gl=new GameLogic(board);
		CellReader creator= new CellReader();
		WindowFrame view=new WindowFrame(gl,creator,50);

	}

}
