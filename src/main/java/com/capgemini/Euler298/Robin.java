package com.capgemini.Euler298;


public class Robin extends Player {

	public Robin() {
		super("Robin");

	}

	@Override
	public void removeNumberFromMemory() {
		memory.remove(0);
	}
}
