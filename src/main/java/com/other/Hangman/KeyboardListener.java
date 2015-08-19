package com.other.Hangman;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardListener extends KeyAdapter {
	WindowFrame parent;
	char pressed;
	public KeyboardListener(WindowFrame windowFrame) {
		parent=windowFrame;
	}

	public void keyPressed(KeyEvent evt) {
	
		    pressed=evt.getKeyChar();
		    callParent(pressed);
		    System.out.println(pressed);
		   
		  
	}
	public void callParent(char c){
		parent.getGl().checkLetterAndMoidifyGaps(c);
		parent.getWrongCounter().setText("Wrong tries: "+parent.getGl().getNumberOfWrongLetter());
		parent.getPointCounter().setText("Ponts:  "+parent.getGl().getNumberOfPoints());
		parent.repaint();
	}
}