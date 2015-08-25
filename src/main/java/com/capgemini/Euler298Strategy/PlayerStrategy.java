package com.capgemini.Euler298Strategy;

import java.util.ArrayList;

public interface PlayerStrategy extends Observer {

	public void checkNumber(int n);
	public void addNumberToMemory(int n);
	public void removeNumberFromMemory();
	public void increasePoints();
	public int getPoints();
	public ArrayList<Integer> getMemory();
	
	
}
