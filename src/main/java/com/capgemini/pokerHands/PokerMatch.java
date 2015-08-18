package com.capgemini.pokerHands;


public class PokerMatch {
	private Player[] players;
	int winner;

	public PokerMatch(Player p1, Player p2) {
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
		winner=playMatch();
	}

	public int playMatch() { //compare players hands
		return players[0].hand.compareTo(players[1].hand);	
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}
	
	
}
