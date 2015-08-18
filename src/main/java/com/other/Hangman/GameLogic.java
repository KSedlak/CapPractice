package com.other.Hangman;

import java.util.ArrayList;

public class GameLogic {
	
	private Word currentWord;
	private Reader reader;
	private int numberOfWrongLetter;
	private int numberOfChecks;
	private HangmanPainting hp;
	private boolean gameOver;
	public GameLogic(Reader reader){
		this.reader=reader;
		hp=new HangmanPainting();
		randomWord();
		
	}
	public GameLogic(){
	
	}
	
	public void checkLetterAndMoidifyGaps(char searchChar){
		numberOfChecks++;
		
	ArrayList<Integer> indexes = currentWord.hasLetter(searchChar);
	int temp=indexes.size();
	String newWord=currentWord.getWordWithGaps();
	for(Integer idx:indexes){
			newWord=replaceLetterAtIndex(newWord, searchChar, idx*2+1);
		}

	if(temp==0){


	if(numberOfWrongLetter<hp.getHg().getLinesOfHangMan().size()){
		numberOfWrongLetter++;
		hp.setPivot(numberOfWrongLetter);}

	}
		

	
	

	
	
	currentWord.setWordWithGaps(newWord);
	}
	
	
	public String replaceLetterAtIndex(String input, char replecment, int idx){
	return	input.substring(0,idx-1)+replecment+input.substring(idx);
		
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
	
	public void randomWord(){
		int  bounds = reader.getListOfWords().size();
		int rand=(int)(Math.random()*bounds);
		setCurrentWord(reader.getListOfWords().get(rand));
		clearScores();
		
	}
	
	public void clearScores(){
		numberOfChecks=0;
		numberOfWrongLetter=0;
		gameOver=true;
		hp.setPivot(0);
		
	}
	public HangmanPainting getHp() {
		return hp;
	}

}
