package com.Hangman;

import java.util.ArrayList;

public class Word {
	String word;
	
	
	public Word(String s){
		word=s;
	}
	
	public ArrayList<Integer> hasLetter(char a){
		ArrayList<Integer> indexes = new ArrayList<>();
			for(int i=0; i<word.length();i++){
				if(word.charAt(i)==a){
					indexes.add(i);
				}
			}
			return indexes;
	}
}
