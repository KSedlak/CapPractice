package com.capgemini.GameOfLifeInitMouse;

public class Game {

	public static void main(String[] args) {
		Board board= new Board(10, 10);
		CellReader creator= new CellReader();
		WindowFrame view=new WindowFrame(board,creator,50);

	}

}
