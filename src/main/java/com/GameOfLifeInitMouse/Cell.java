package com.GameOfLifeInitMouse;

import java.util.ArrayList;

public class Cell {
	private LifeStatus currentState;
	private LifeStatus nextState;
	private ArrayList<Cell> neighbours;
	private int id;

	public Cell(LifeStatus s) {
		currentState = s;
	}

	public ArrayList<Cell> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<Cell> neighbours) {
		this.neighbours = neighbours;
	}

	public int getNumberOfLifeNeighbours() {
		int numberofNeighbours = 0;
		for (Cell c : neighbours) {
			if (c.currentState.equals(LifeStatus.Life)) {
				numberofNeighbours++;
			}
		}
		return numberofNeighbours;
	}

	public LifeStatus getCurrentState() {
		return currentState;
	}

	public void setCurrentState(LifeStatus currentState) {
		this.currentState = currentState;
	}

	public LifeStatus getNextState() {
		return nextState;
	}

	public void setNextState(LifeStatus nextState) {
		this.nextState = nextState;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void changeLifeStatus() {
		int temp = currentState.ordinal();
		int newIndex = (temp + 1) % LifeStatus.values().length;
		setCurrentState(LifeStatus.values()[newIndex]);
	}

}
