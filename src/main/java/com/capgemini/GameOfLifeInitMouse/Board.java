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
		initRandomMap();
	}
	public void initMap() {
		map.clear();
		int count=0;

		for(int i =0; i<height;i++){
			for(int j =0; j<width;j++){
				int[] tab={j,i};
				map.put(new Position(tab),listOfCells.get(count));	
				count++;
			}
			}

	}
	public void initRandomMap() {
			initializeRandomCells(width*height);
			initMap();
		
		
	}
	public void randomizeExistCellsInMap(){
		int random;
		for(Cell c:map.values()){
			random=(int)(Math.random()*LifeStatus.values().length);
			c.setCurrentState(LifeStatus.values()[random]);
		}
		
	}
	public void initializeRandomCells(int size){
		int random;
		listOfCells.clear();
		for(int i=0;i<size;i++){
			random=(int)(Math.random()*LifeStatus.values().length);
			listOfCells.add(new Cell(LifeStatus.values()[random]));
		}
	}
	
	public void ClearBoard(){
		for(Cell c:map.values()){
			c.setCurrentState(LifeStatus.Dead);
			c.setNextState(LifeStatus.Dead);
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
	public Cell getCell(int idx){
		return listOfCells.get(idx);
	}


	public void setBoardMatrixFromFile(ArrayList<Cell> cells)  {
		setListOfCells(cells);
		initMap();
		
		}
	
}
