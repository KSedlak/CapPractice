package com.other.Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	private ArrayList<Word> listOfWords;

	public Reader() throws IOException {
		readFile();
	}

	public void readFile() throws IOException {
		listOfWords = new ArrayList<Word>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/main/java/com/other/Hangman/words.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			String line = br.readLine();

			while (line != null) {
				listOfWords.add(new Word(line));
				line = br.readLine();

			}

		} finally {
			br.close();

		}
	}

	public ArrayList<Word> getListOfWords() {
		return listOfWords;
	}

}
