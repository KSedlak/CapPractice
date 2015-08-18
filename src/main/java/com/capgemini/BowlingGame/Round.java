package com.capgemini.BowlingGame;

import java.util.ArrayList;

public class Round {
	private ArrayList<ThrowBall> thrList;
	private int number;
	private boolean isFinished;
	private int score;
	private int extraThrows;
	public Round(int n) {
		thrList = new ArrayList<ThrowBall>();
		isFinished = false;
		number = n;
		extraThrows=0;
	}
	public boolean roundFinished(){
		return isFinished && extraThrows==0;
	}

	public ArrayList<ThrowBall> getThrList() {
		return thrList;
	}

	public void setThrList(ArrayList<ThrowBall> thrList) {
		this.thrList = thrList;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addThrow(ThrowBall t) {
		thrList.add(t); 
		score = score + t.getPoints();
		if (t.getPoints() == 10) { //strike
			isFinished = true;
			extraThrows=2;
		}
		if (thrList.size() == 2) {
			isFinished = true;
			if (score == 10) { //spare
				extraThrows=1;
			}
		}

	}

	public void addExtra(ThrowBall t ) {   //add extra point from next trows
		if(this.extraThrows>0 && number<10){
		thrList.add(t);
		score = score + t.getPoints();
		extraThrows--;
	}
}
	public int getNumber() {
		return number;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public int getExtraThrows() {
		return extraThrows;
	}
	
	
}