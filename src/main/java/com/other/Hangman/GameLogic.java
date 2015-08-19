package com.other.Hangman;

import java.util.ArrayList;

public class GameLogic {

	private Word currentWord;
	private Reader reader;
	private int numberOfWrongLetter;
	private int numberOfChecks;
	private HangmanPainting hp;
	private String wordWithGaps;
	private int numberOfPoints;
	
	public GameLogic(Reader reader) {
		this.reader = reader;
		hp = new HangmanPainting();
		randomWord();
		numberOfPoints=0;

	}

	public GameLogic() {

	}

	public void checkLetterAndMoidifyGaps(char searchChar) {
		numberOfChecks++;

		ArrayList<Integer> indexes = currentWord.hasLetter(searchChar);
		int temp = indexes.size();
		String newWord = wordWithGaps;
		for (Integer idx : indexes) {
			newWord = replaceLetterAtIndex(newWord, searchChar, idx * 2 + 1);
		}

		if (temp == 0) {
			++numberOfWrongLetter;
			if (numberOfWrongLetter < hp.getHg().getLinesOfHangMan().size()) {
				
				hp.setPivot(numberOfWrongLetter);}
			if(numberOfWrongLetter == hp.getHg().getLinesOfHangMan().size()){
				hp.setGr(GameResult.Looser);
				hp.setPivot(numberOfWrongLetter);}
		
		}
		

		wordWithGaps=newWord;
		iAmWinning();
	}

	public void iAmWinning(){
		
	String temp=wordWithGaps.replace(" ", "");
	if(temp.equals(currentWord.getWord())){
			hp.setGr(GameResult.Winner);
			numberOfPoints++;
		}
	}


	public String replaceLetterAtIndex(String input, char replecment, int idx) {
		return input.substring(0, idx - 1) + replecment + input.substring(idx);

	}

	public String createWordWithGaps(){
		String res="";
		for(int i=0;i<currentWord.getWord().length()-1;i++){
			res=res+"_ ";
		}
		res=res+"_";
		return res;
	}
	public void randomWord() {
		int bounds = reader.getListOfWords().size();
		int rand = (int) (Math.random() * bounds);
		setCurrentWord(reader.getListOfWords().get(rand));
		wordWithGaps=createWordWithGaps();
		clearScores();

	}

	public void clearScores() {
		numberOfChecks = 0;
		numberOfWrongLetter = 0;
		hp.setPivot(0);
		hp.setGr(null);

	}
	
	public int getNumberOfPoints() {
		return numberOfPoints;
	}
	public HangmanPainting getHp() {
		return hp;
	}
	public String getWordWithGaps() {
		return wordWithGaps;
	}

	public void setWordWithGaps(String wordWithGaps) {
		this.wordWithGaps = wordWithGaps;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public int getNumberOfWrongLetter() {
		return numberOfWrongLetter;
	}

	public void setNumberOfWrongLetter(int numberOfWrongLetter) {
		this.numberOfWrongLetter = numberOfWrongLetter;
	}

	public int getNumberOfChecks() {
		return numberOfChecks;
	}

	public void setNumberOfChecks(int numberOfChecks) {
		this.numberOfChecks = numberOfChecks;
	}

	public Word getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(Word currentWord) {
		this.currentWord = currentWord;
	}
}
