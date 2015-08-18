package com.other.Hangman;

import java.util.ArrayList;

public class HangmanDraw {
	private ArrayList<FigureCoordinates> linesOfHangMan;

public HangmanDraw(){
	initDrawing();
}





	public void initDrawing() {
		linesOfHangMan = new ArrayList<FigureCoordinates>();
		linesOfHangMan.add(new FigureCoordinates(100, 200, 130, 200));
		linesOfHangMan.add(new FigureCoordinates(100, 200, 100, 50));
		linesOfHangMan.add(new FigureCoordinates(100, 50, 200, 50));
		linesOfHangMan.add(new FigureCoordinates(200, 50, 200, 80));
		linesOfHangMan.add(new FigureCoordinates(190, 80, 25, 25,true));
		linesOfHangMan.add(new FigureCoordinates(200, 105, 200, 110));
		linesOfHangMan.add(new FigureCoordinates(200, 110, 175, 130));
		linesOfHangMan.add(new FigureCoordinates(200, 110, 225, 130));
		linesOfHangMan.add(new FigureCoordinates(200, 110, 200, 150));
		linesOfHangMan.add(new FigureCoordinates(200, 150, 175, 180));
		linesOfHangMan.add(new FigureCoordinates(200, 150, 225, 180));
	}





	public ArrayList<FigureCoordinates> getLinesOfHangMan() {
		return linesOfHangMan;
	}
	
}
