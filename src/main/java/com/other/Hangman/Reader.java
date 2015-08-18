package com.other.Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.capgemini.pokerHands.Player;
import com.capgemini.pokerHands.PokerMatch;

public class Reader {
	
	ArrayList<Word> listOfWords;
	
	public void readFile() throws IOException {
			listOfWords=new ArrayList<Word>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/main/java/com/Hangman/words.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			String line = br.readLine();

			while (line != null) {
			System.out.println(line);
				listOfWords.add(new Word(line));
				line = br.readLine();

			}

		} finally {
			br.close();
			//System.out.println("File loaded: "+matchList.size()+" matches");

		}
	}


}
