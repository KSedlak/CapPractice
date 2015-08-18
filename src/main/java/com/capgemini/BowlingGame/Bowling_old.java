package com.capgemini.BowlingGame;

public class Bowling_old implements BowlingGameResultCalculator {

	int[][] scoreTable;
	/*
	 * 1 2 3 4 5 6 rounds [ ][ ][ ][ ][ ][ ][ actualHit [ ][ ][ ][ ][ ][ ][ sum
	 */
	private int acctualScore;
	private int acctualRound=0;
	private int throwsOfGame;
	private int strikes=0;
	private int maxRounds=10;
	public Bowling_old() {
		scoreTable = new int[3][22];//22 max throws number 10*2 per round and 2 extra if strike in last 10 round
		throwsOfGame = 0;
	}

	public void roll(int numberOfPins) {
		scoreTable[0][throwsOfGame] = numberOfPins;
		wasStrike(throwsOfGame);
		wasSpare(throwsOfGame);
		if(numberOfPins==10){
			strikes++;
		}

		throwsOfGame++;
		
		acctualRound=((int)((throwsOfGame-strikes)/2)+strikes);
		if(acctualRound==10 && numberOfPins==10){maxRounds=12;}//strike in last
		if(acctualRound==10 && scoreTable[0][throwsOfGame-2]+scoreTable[0][throwsOfGame-1]==10){maxRounds=11;}//spare in last

	}

	public int score() {
		for (int j = 0; j < scoreTable[0].length; j++) {
			for (int i = 0; i < 3; i++) {
				acctualScore = acctualScore + scoreTable[i][j];
			}
		}

		//printscoreTab();
		return acctualScore;
	}

	public void printscoreTab() {
		String buff = "";
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 22; i++) {
				buff = buff + " | " + scoreTable[j][i];
			}
			System.out.println(buff);
			buff = "";
		}

	}

	public boolean isFinished() {
		return acctualRound==maxRounds;
	}

	public void wasSpare(int thr) {
		if (thr - 2 >= 0) {
			if (scoreTable[0][thr - 1] != 0 && scoreTable[0][thr - 2] != 0
					&& scoreTable[0][thr - 1] + scoreTable[0][thr - 2] == 10) {
				scoreTable[1][thr - 1] = scoreTable[0][thr];
			}
		}
	}
	
	public void wasStrike(int thr) {
		if (thr - 1 >= 0) {
			
			if (scoreTable[0][thr - 1]==10 && acctualRound<10){
				scoreTable[1][thr - 1] = scoreTable[0][thr];
			}
		}
			if (thr - 2 >= 0) {	
			if (scoreTable[0][thr - 2]==10 && acctualRound<=10){
				scoreTable[2][thr - 2] = scoreTable[0][thr];
			}
			}
	}

}
