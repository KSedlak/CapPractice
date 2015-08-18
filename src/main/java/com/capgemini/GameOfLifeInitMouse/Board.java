package com.capgemini.GameOfLifeInitMouse;

import java.util.ArrayList;

public class Board {
	private int w;
	private int h;
	private ArrayList<Cell> listOfCells;
	private int generation;

	public Board(int w, int h) {
		this.w = w;
		this.h = h;
		listOfCells = new ArrayList<Cell>();
		generation = 0;
	}

	public void initMatrixRandom() {
		int rand;
		listOfCells.clear();
		for (int j = 0; j < h; j++) {
			for (int k = 0; k < w; k++) {
				rand = (int) (Math.random() * LifeStatus.values().length);
					listOfCells.add(new Cell(LifeStatus.values()[rand]));
				}
				listOfCells.get(listOfCells.size() - 1).setId(listOfCells.size() - 1);
			}
		generateNeighboursListForMatrix();
	}

	public void initMatrixChoosenLifeStatus(LifeStatus s) {
		int rand;
		listOfCells.clear();
		for (int j = 0; j < h; j++) {
			for (int k = 0; k < w; k++) {
				rand = (int) (Math.random() * LifeStatus.values().length);
					listOfCells.add(new Cell(s));
				}
				listOfCells.get(listOfCells.size() - 1).setId(listOfCells.size() - 1);
			}
		generateNeighboursListForMatrix();
	}
	
	public void generateNeighboursListForMatrix() {
		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				ArrayList<Cell> n = new ArrayList<Cell>();
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {
						if (i >= 0 && j >= 0 && // lower bounds
								i < h && j < w && // upper bounds
								!(i == x && j == y) // slef remove
						) {
							n.add(getCell(i * w + j));
						}
					}
				}
				getCell(x * w + y).setNeighbours(n);
			}
		}
	}


	public void nextGeneration() {
		for (Cell c : listOfCells) {//calculate next states
			int temp = c.getNumberOfLifeNeighbours();
			LifeStatus curr = c.getCurrentState();
			c.setNextState(curr);
			
			if (curr.equals(LifeStatus.Life) && (temp < 2 || temp > 3)) 
				c.setNextState(LifeStatus.Dead);
			
			
			if (curr.equals(LifeStatus.Dead) && temp == 3) 
				c.setNextState(LifeStatus.Life);
		}
	
		generation++;
		for (Cell c : listOfCells) {//switch current to next state
			c.setCurrentState(c.getNextState());
		}

	}
	public int getW() {
		return w;
	}

	public void setWidth(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setHeight(int h) {
		this.h = h;
	}

	public ArrayList<Cell> getListOfCells() {
		return listOfCells;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public Cell getCell(int id) {
		return listOfCells.get(id);
	}
	public void setCellList(ArrayList<Cell> l) {
		listOfCells = l;

	}
}
