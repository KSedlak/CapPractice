package com.capgemini.Euler298Strategy;

import java.util.ArrayList;

public class Robin implements PlayerStrategy, Observer {
	private int points;
	private static int memorySize = 5;
	ArrayList<Integer> memory;
	
	public Robin() {
		points = 0;
		memory = new ArrayList<Integer>();

	}

	@Override
	public void removeNumberFromMemory() {
		memory.remove(0);
	}

	@Override
	public void update(int newNumber) {
		checkNumber(newNumber);
		
	}

	@Override
	public void checkNumber(int n) {
		if (memory.contains(n)) {
			increasePoints();
		} 
		else {
			addNumberToMemory(n);
		}
		
	}

	@Override
	public void addNumberToMemory(int n) {
		if (memory.size() == getMemorySize())
		{
			removeNumberFromMemory();
		}
		
		memory.add(n);
		
	}
	@Override
	public void increasePoints() {
		points++;
		
	}
	@Override
	public int getPoints() {
		return points;
	}
	public static int getMemorySize() {
		return memorySize;
	}

	@Override
	public ArrayList<Integer> getMemory() {
		
		return memory;
	}

	
}
