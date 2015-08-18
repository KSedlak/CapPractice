package com.capgemini.GameOfLifeWithoutMouse;

import java.util.ArrayList;

public class GameOfLife {
	int w;
	int h;
	ArrayList<Cell> listOfCells;
	ArrayList<Cell> toDie;
	ArrayList<Cell> toResurrect;
	int generation;
	public GameOfLife(int w, int h) {
		this.w = w;
		this.h = h;
		toDie = new ArrayList<Cell>();
		toResurrect = new ArrayList<Cell>();
		listOfCells = new ArrayList<Cell>();
		generation=0;
	}

	public void initMatrix() {
		int rand;
		listOfCells.clear();
		for (int j = 0; j < w; j++) {
			for (int k = 0; k < h; k++) {
				rand = (int) (Math.random() * 2) + 1;

				if (rand == 1) {
					listOfCells.add(new Cell(j, k, true));
				} else {
					listOfCells.add(new Cell(j, k, false));
				}

			}
		}

		generateNeighboursList();
	}

	public void setCellList(ArrayList<Cell> l) {
		listOfCells = l;

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

	public void generateNeighboursList() {
		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				ArrayList<Cell> n = new ArrayList<Cell>();
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {
						if (i >= 0 && j >= 0 && // lower bounds
								i < h && j < w && // upper bounds
								!(i == x && j == y) // slef remove
						) {
							n.add(getCell(i, j));
						}

					}
				}
				// System.out.println(a+" vv "+b);
				getCell(x, y).setNeighbours(n);

			}
		}
	}

	public Cell getCell(int x, int y) {
		return listOfCells.get(x * w + y);
	}

	public void nextGeneration() {
		for (Cell c : listOfCells) {
			if (!c.lifeStatus && c.neighboursValue == 3) { // back to life
				toResurrect.add(c);
			}
			if (c.lifeStatus) {
				if (c.neighboursValue < 2 || c.neighboursValue > 3) { // die
					toDie.add(c);
				}
			}
		}
		// execute for next status
		for (Cell c : toDie) {
			c.die();
		}
		for (Cell c : toResurrect) {
			c.backToLife();
		}
		// clear list

		toDie.clear();
		toResurrect.clear();
		generation++;
	}

	public void printSImple() {
		int counter = 0;
		String buff = "";
		for (Cell c : listOfCells) {
			buff = buff + " | " + c.lifeString();
			counter++;
			if (counter % 3 == 0) {
				buff = buff + "\n";
			}
		}
		System.out.println(buff);
	}

}
