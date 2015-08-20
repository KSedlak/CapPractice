package com.capgemini.Euler298;

import java.util.ArrayList;

public class EulerMachine implements Observable {
	ArrayList<Player> observers;
	int generatedNumber;
	
	public EulerMachine() {
	generatedNumber=0;
	observers=new ArrayList<>();
	}

	@Override
	public void addObserver(Observer obs) {
			observers.add((Player)obs);
		
	}

	@Override
	public void deleteObservers() {
		observers.clear();
		
	}


	public void notifyObservers() {
		for(Observer o:observers){
			o.update(generatedNumber);
		}
		
	}
		
	public int generateRandomNumber(){
		return (int) (Math.random()*10+1);
		
	}
	
	public void callNumber(){
		generatedNumber=generateRandomNumber();
		notifyObservers();
	}
	public void callSpecifiedNumber(int c){
		generatedNumber=c;
		notifyObservers();
	}



}
