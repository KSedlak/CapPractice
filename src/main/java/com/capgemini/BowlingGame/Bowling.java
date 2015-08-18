package com.capgemini.BowlingGame;

import java.util.ArrayList;

public class Bowling implements BowlingGameResultCalculator {
	private ArrayList<Round> match;
	private boolean startNewRound;

	public Bowling() {
		match = new ArrayList<Round>();
		startNewRound = true;
		Round r = new Round(1);
		match.add(r);
	}

	public void roll(int numberOfPins) {
		Round r;
		if (match.get(match.size() - 1).isFinished()) { // if last round is finished
			r = new Round(match.size() + 1);// start new round
			match.add(r);
		} 
		else {
			r = match.get(match.size() - 1);// jesli nie rozpoczynam nowej to
											// biore ostatnia aktualna
		}
		ThrowBall t = new ThrowBall(numberOfPins);
		r.addThrow(t);// dodaj rzut do biezacej rundy
		
		// check previous strike/spare
		if (match.size() > 2 && match.get(match.size() - 3).getExtraThrows() > 0) {//sprawdz czy dwie rundy do tylu jeszcze przysluguje jakas premia
			match.get(match.size() - 3).addExtra(t);
		}
		if (match.size() > 1 && match.get(match.size() - 2).getExtraThrows() > 0) { // sprawdz czy poprzednia runda jest premiowana
			match.get(match.size() - 2).addExtra(t);
		}

	}

	public void printRoundsScore() {
		for (Round r : match) {
			System.out.println("Runda: " + r.getNumber() + " score:" + r.getScore());
		}
	}

	public int score() {
		int score = 0;
		for (Round r : match) {
			score = score + r.getScore();
		}
		return score;
	}

	public boolean isFinished() {
		if (match.size() == 10 && match.get(match.size() - 1).roundFinished()) {// 10 rund i ostatnia jest zakonczona																	// zakonczona
			return true;
		} else
			return false;
	}

}
