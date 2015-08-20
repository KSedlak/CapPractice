package com.capgemini.Euler298;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Larry extends Player {

	private TreeMap<Integer, Integer> history;
	private int round;

	public Larry() {
		super("Larry");
		round = 0;
		history = new TreeMap<>();

	}

	@Override
	public void removeNumberFromMemory() {
		memory.remove(getIdxLongestNotCalledNumber());

	}

	public void addToHistory(int n) {
		history.put(n, round);
	}

	public int getIdxLongestNotCalledNumber() {

		for (Integer i : history.keySet()) {
		}
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
		} else {
			addNumberToMemory(n);
		}
	}

}
