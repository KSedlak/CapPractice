package GameOfLifeWithoutMouse;

import java.util.ArrayList;

public class Cell {
	int neighboursValue;
	int x;
	int y;
	boolean lifeStatus;
	ArrayList<Cell> neighbours;
	public int getNeighboursValue() {
		return neighboursValue;
	}
	public void setNeighboursValue(int neighboursValue) {
		this.neighboursValue = neighboursValue;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isLifeStatus() {
		return lifeStatus;
	}
	public void setLifeStatus(boolean lifeStatus) {
		this.lifeStatus = lifeStatus;
	}
	public boolean getLifeStatus() {
		return lifeStatus;
	}
	public Cell(int x, int y, boolean lifeStatus) {
		this.x = x;
		this.y = y;
		this.lifeStatus = lifeStatus;
	}
	public ArrayList<Cell> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(ArrayList<Cell> neighbours) {
		int nVal=0;
	
		for(Cell c:neighbours){
			if(c.lifeStatus)
				{nVal++;
				
				}
		}
		this.neighbours = neighbours;
		this.neighboursValue=nVal;
	}
	
	public void die(){
		for(Cell c: neighbours){
			c.neighboursValue--;
		}
		lifeStatus=false;
	}
	public void backToLife(){
		for(Cell c: neighbours){
			c.neighboursValue++;
		}
		lifeStatus=true;
	}
	public String lifeString(){
		if(lifeStatus){
			return "L";
		}
		else{
			return "D";
		}
	}
}
