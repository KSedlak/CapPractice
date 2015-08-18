package com.other.Hangman;

import java.util.ArrayList;

public class Word {
	private String word;
	private String wordWithGaps;
	public Word(String s){
		word=s.toLowerCase();
		wordWithGaps=createWordWithGaps();
	}
	
	public ArrayList<Integer> hasLetter(char a){ /// return indexes where char is
		ArrayList<Integer> indexes = new ArrayList<>();
			for(int i=0; i<word.length();i++){
				if(word.charAt(i)==a){
					indexes.add(i);
				
				}
			}
			return indexes;
	}

	public String getWord() {
		return word;
	}
	
	public String createWordWithGaps(){
		String res="";
		for(int i=0;i<word.length()-1;i++){
			res=res+"_ ";
		}
		res=res+"_";
		return res;
	}

	public String getWordWithGaps() {
		return wordWithGaps;
	}

	public void setWordWithGaps(String wordWithGaps) {
		this.wordWithGaps = wordWithGaps;
	}
	
}
