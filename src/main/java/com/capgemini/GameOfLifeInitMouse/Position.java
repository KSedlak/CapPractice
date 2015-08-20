package com.capgemini.GameOfLifeInitMouse;

import java.util.ArrayList;

public class Position{
	private int[] cords;
	ArrayList<Position> neighbourhood;
	public Position(int[]c) {
		super();
	cords=c;
	
	}

	public int getDistanceFrom(Position o) {
	int distance=0;
	int temp=0;
	if(this.cords.length==o.cords.length){
		
	
	for(int i=0;i<this.cords.length;i++){
		temp=this.cords[i]-o.cords[i];
	
		distance=distance+(int)Math.pow(temp, 2);
	}

	}
	
		return distance;
	}


	public int[] getCords() {
		return cords;
	}


	public void setCords(int[] cords) {
		this.cords = cords;
	}
	

}
