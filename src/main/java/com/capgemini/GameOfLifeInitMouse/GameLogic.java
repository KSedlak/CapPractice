package com.capgemini.GameOfLifeInitMouse;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class GameLogic {

	private Board board;
	private	int generation; 

	
	public GameLogic(Board b) {
		board=b;
		generation=0;
		generateNeighboursList();
		
	}

	public void nextGeneration() {
		for (Cell c : board.getListOfCells()) {//calculate next states
			int temp = c.getNumberOfLifeNeighbours();
			LifeStatus curr = c.getCurrentState();
			c.setNextState(curr);
			if (curr.equals(LifeStatus.Life) && (temp < 2 || temp > 3)) 
				c.setNextState(LifeStatus.Dead);
			
			
			if (curr.equals(LifeStatus.Dead) && temp == 3) 
				c.setNextState(LifeStatus.Life);
		}
	
		generation++;
		for (Cell c : board.getListOfCells()) {//switch current to next state
			c.setCurrentState(c.getNextState());
		}

	}
	public void generateNeighboursList() {
		int distance=0;
		for(Entry<Position, Cell> mapEntry:board.getMap().entrySet()){
			ArrayList<Cell> tempNeigh =new ArrayList<>();		
				for(Entry<Position, Cell> mapEntry2:board.getMap().entrySet()){
					distance=mapEntry.getKey().getDistanceFrom(mapEntry2.getKey());
					if(distance!=0 && distance<=2){
						tempNeigh.add(mapEntry2.getValue());
					}
				}
			mapEntry.getValue().setNeighbours(tempNeigh);
		}
}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}




	public Board getBoard() {
		return board;
	}
		
	
	public void randomBoard(){
		board.randomizeExistCellsInMap();
		generation=0;
		generateNeighboursList();
	}



	public void setBoard(Board board) {
		this.board = board;
		generation=0;
		generateNeighboursList();
	}

	public void refreshBoard() {
		generation=0;
		generateNeighboursList();
		
	}
	


}
