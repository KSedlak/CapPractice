package com.other.Hangman;

import java.util.ArrayList;

import com.capgemini.GameOfLifeInitMouse.LifeStatus;

public class GameLogic {

	private Word currentWord;
	private Reader reader;
	private int numberOfWrongLetter;
	private int numberOfChecks;
	private HangmanPainting hp;
	private int numberOfReplacment;
	private String wordWithGaps;
	
	public GameLogic(Reader reader) {
		this.reader = reader;
		hp = new HangmanPainting();
		randomWord();

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
			numberOfReplacment++;
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
		}
	}
	
	public String replaceLetterAtIndex(String input, char replecment, int idx) {
		return input.substring(0, idx - 1) + replecment + input.substring(idx);

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

	public String getWordWithGaps() {
		return wordWithGaps;
	}

	public void setWordWithGaps(String wordWithGaps) {
		this.wordWithGaps = wordWithGaps;
	}

	public void clearScores() {
		numberOfChecks = 0;
		numberOfWrongLetter = 0;
		numberOfReplacment=0;
		hp.setPivot(0);
		hp.setGr(null);

	}

	public HangmanPainting getHp() {
		return hp;
	}

}
