package com.capgemini.Euler298Strategy;


import java.util.ArrayList;
import java.util.TreeMap;

public class Larry implements PlayerStrategy, Observer {

	private TreeMap<Integer, Integer> history;
	private int round;
	private int points;
	private static int memorySize = 5;
	ArrayList<Integer> memory;
	public Larry() {
		round = 0;
		history = new TreeMap<>();
		points = 0;
		memory = new ArrayList<Integer>();
	}

	@Override
	public void removeNumberFromMemory() {
		memory.remove(getIdxLongestNotCalledNumber());

	}

	public void addToHistory(int n) {
		history.put(n, round);
	}

	public int getIdxLongestNotCalledNumber() {

		int minIdx = 0;// round for first elemnt from memory
		for (int i = 0; i < memory.size(); i++) {
			if (history.get(memory.get(i)) < history.get(memory.get(minIdx))) {
				minIdx = i;
			}
		}
		return minIdx;
	}

	public void checkNumber(int n) {
		addToHistory(n);
		round++;
		if (memory.contains(n)) {
			increasePoints();
		} 
		else {
			addNumberToMemory(n);
		}
	}

	@Override
	public void update(int newNumber) {
		checkNumber(newNumber);
		
	}

	@Override
	public void addNumberToMemory(int n) {
		if (memory.size() == getMemorySize())
		{
			removeNumberFromMemory();
		}
		
		memory.add(n);
		
	}

	
	public static int getMemorySize() {
		return memorySize;
	}

	@Override
	public void increasePoints() {
		points++;
		
	}
	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public ArrayList<Integer> getMemory() {
		// TODO Auto-generated method stub
		return memory;
	}

}
