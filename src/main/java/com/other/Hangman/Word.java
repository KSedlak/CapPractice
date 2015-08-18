package com.other.Hangman;

import java.util.ArrayList;

public class Word {
	private String word;

	public Word(String s){
		word=s.toLowerCase();

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
	



}
