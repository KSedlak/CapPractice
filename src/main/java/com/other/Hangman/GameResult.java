package com.other.Hangman;

import java.awt.Color;

public enum GameResult {
Winner("You win", Color.GREEN),
Looser("Game Over", Color.RED);

private String message;
private Color color;

private GameResult(String m, Color c){
	message=m;
	color=c;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}


}
