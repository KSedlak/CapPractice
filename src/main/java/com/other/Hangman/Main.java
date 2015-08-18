package com.other.Hangman;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Reader readerForWords = new Reader();
		GameLogic game=new GameLogic(readerForWords);
		WindowFrame window= new WindowFrame(game);

	}

}
