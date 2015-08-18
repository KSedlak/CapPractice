package com.capgemini.pokerHands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DeckMaker {
private ArrayList<PokerMatch> matchList;



public DeckMaker() throws IOException{
	matchList=new ArrayList<PokerMatch>();
	readFile();
}
	
	
	
	public void readFile() throws IOException {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/main/java/com/capgemini/pokerHands/poker.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			String line = br.readLine();

			while (line != null) {
				Player[] players=convertStringToPlayers(line);
				matchList.add(new PokerMatch(players[0], players[1]));
				line = br.readLine();

			}

		} finally {
			br.close();
			//System.out.println("File loaded: "+matchList.size()+" matches");

		}
	}

	public Player[] convertStringToPlayers(String input){
		String[] temp=input.split(" ");
		int numberPlayers= temp.length/5;
		Player[] result = new Player[numberPlayers];
		for(int j=0;j<numberPlayers;j++){
			Hand h = new Hand();
			for (int i = 5*j; i < (5*(j+1)); i++) {
				h.addToHand(convertStringToCard(temp[i]));
				}
		
			result[j]=new Player(h);
		}
		return result;
	}
	
	public Card convertStringToCard(String input){
		Suit cs= convertStringToSuit(input.substring(1, 2));
		Rank cr= convertStringToRank(input.substring(0, 1));
		return new Card(cr,cs);
	}
	public Suit convertStringToSuit(String input){
		switch (input) {
		//CLUBS, DIAMONDS, HEARTS, SPADES;	
	        case "C":
	           return Suit.CLUBS;
	    
	        case "D":
		           return Suit.DIAMONDS;
		            
	        case "H":
		           return Suit.HEARTS;
		            
	        case "S":
		           return Suit.SPADES;
		            
	        default:
	            throw new IllegalArgumentException("Invalid input " + input);
		}
	}
	public Rank convertStringToRank(String input){
		switch (input) {
	/*	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, 
        NINE, TEN, JACK, QUEEN, KING, ACE*/		
        case "2":
           return Rank.TWO;
            
        case "3":
            return Rank.THREE;
             
        case "4":
            return Rank.FOUR;
             
        case "5":
            return Rank.FIVE;
             
        case "6":
            return Rank.SIX;
             
        case "7":
            return Rank.SEVEN;
             
        case "8":
            return Rank.EIGHT;
             
        case "9":
            return Rank.NINE;
             
        case "T":
            return Rank.TEN;
             
        case "J":
            return Rank.JACK;
             
        case "Q":
            return Rank.QUEEN;
             
        case "K":
            return Rank.KING;
             
        case "A":
            return Rank.ACE;
              
        default:
            throw new IllegalArgumentException("Invalid input " + input);
	}
	}



	public ArrayList<PokerMatch> getMatchList() {
		return matchList;
	}



	public void setMatchList(ArrayList<PokerMatch> matchList) {
		this.matchList = matchList;
	}
	

}
