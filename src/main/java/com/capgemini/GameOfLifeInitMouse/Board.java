package com.capgemini.GameOfLifeInitMouse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class Board {


	private LinkedHashMap<Position, Cell> map;
	private ArrayList<Cell> listOfCells;
	int width;
	int height;
	
	public Board(int a, int b) {
		width=a;
		height=b;
		map = new LinkedHashMap<>();
		listOfCells = new ArrayList<Cell>();
		
	}

	public void initPositionsForMatrix() {
		int rand;
		for(int i =0; i<height;i++){
			for(int j =0; j<width;j++){
				int[] tab={j,i};
				rand=(int)(Math.random()*2);
				Position p=new Position(tab);
				System.out.println(j+" "+i+" life: "+rand);
				Cell ce=new Cell(LifeStatus.values()[rand]);
				map.put(p, ce);
				listOfCells.add(ce);
				
			}
		}

	}



	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public LinkedHashMap<Position, Cell> getMap() {
		return map;
	}

	public void setMap(LinkedHashMap<Position, Cell> map) {
		this.map = map;
	}

	public ArrayList<Cell> getListOfCells() {
		return listOfCells;
	}

	public void setListOfCells(ArrayList<Cell> listOfCells) {
		
		this.listOfCells = listOfCells;
		
	}


	public void setBoardMatrixFromFile(ArrayList<Cell> cells)  {
		map.clear();
		int count=0;
		for(int i =0; i<height;i++){
			for(int j =0; j<width;j++){
				int[] tab={j,i};
				Position p=new Position(tab);
				Cell ce=cells.get(count);
				map.put(p, ce);
				count++;
				setListOfCells(cells);			
			}
		}

	}




	
}
