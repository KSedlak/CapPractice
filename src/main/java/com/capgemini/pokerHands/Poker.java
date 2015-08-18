package com.capgemini.pokerHands;


import java.io.IOException;



public class Poker {

	private DeckMaker dm;
	private int p1Wins;
	private int match;
	
	public Poker() throws IOException {
		dm=new DeckMaker();
		match=0;
		p1Wins=0;
		
	}

	public void playAllMatchesAndCountPlayer1Winnings(){
		for(PokerMatch pm :dm.getMatchList()){
		if(pm.getWinner()==0){
			p1Wins=p1Wins+1;
		}
		System.out.println("Match number: "+(++match)+" Winner: "+pm.getWinner());
		}
		System.out.println("Player1 wins: "+p1Wins);
	}

	public int getP1Wins() {
		return p1Wins;
	}

	public void setP1Wins(int p1Wins) {
		this.p1Wins = p1Wins;
	}



}
