package com.capgemini.Euler298;

import java.util.ArrayList;

public abstract class Player implements Observer {
	private String name;
	private int points;
	private static int memorySize = 5;
	ArrayList<Integer> memory;

	public Player(String name) {
		super();
		this.name = name;
		points = 0;
		memory = new ArrayList<Integer>();

	}

	@Override
	public void update(int newNumber) {
		checkNumber(newNumber);

	}

	public void addNumberToMemory(int n) {
		if (memory.size() == getMemorySize())
		{
			removeNumberFromMemory();
		}
		
		memory.add(n);
	}

	public abstract void removeNumberFromMemory();

	public static int getMemorySize() {
		return memorySize;
	}

	public void checkNumber(int n) {

		if (memory.contains(n)) {
			increasePoints();
		} 
		else {
			addNumberToMemory(n);
		}
	}

	public void increasePoints() {
		points++;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public ArrayList<Integer> getMemory() {
		return memory;
	}

}
