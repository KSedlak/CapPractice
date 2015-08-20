package com.capgemini.Euler298;


public class Robin extends Player {

	public Robin() {
		super("Robin");

	}

	@Override
	public void addNumberToMemory(int n) {
		if (memory.size() == super.getMemorySize()) {
			removeNumberFromMemory();
		}
		memory.add(n);
	}

	@Override
	public void removeNumberFromMemory() {
		memory.remove(0);
	}

	public void checkNumber(int n) {
		if (memory.contains(n)) {
			increasePoints();
		} else {
			addNumberToMemory(n);
		}
	}
}
