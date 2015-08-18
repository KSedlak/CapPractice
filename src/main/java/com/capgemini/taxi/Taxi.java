package com.capgemini.taxi;

public class Taxi implements Comparable{
	private boolean avability;
	private int number;
	private Position pos;
	private double distanceForCustomer;
   
	public Taxi(Position p, int n){
	 pos=p;
	 number=n;
	}
	
	public boolean isAvability() {
		return avability;
	}
	public void setAvability(boolean avability) {
		this.avability = avability;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public double getDistanceForCustomer() {
		return distanceForCustomer;
	}
	public void setDistanceForCustomer(double distanceForCustomer) {
		this.distanceForCustomer = distanceForCustomer;
	}

	public int compareTo(Object o) {
		Taxi t =(Taxi)o;
		if(t.distanceForCustomer>this.distanceForCustomer){
		return -1;}
		else if(t.distanceForCustomer<this.distanceForCustomer){
			return 1;
		}
		else {
			return 0;
			}
	}

	@Override
	public String toString() {
		int dist=(int)this.distanceForCustomer;
		return "Taxi nr: "+number+" distance: "+dist+" [meters]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	
	
	
}
