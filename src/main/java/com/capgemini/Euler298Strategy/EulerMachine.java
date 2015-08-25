package com.capgemini.Euler298Strategy;

import java.util.ArrayList;

public class EulerMachine implements Observable {
	ArrayList<PlayerStrategy> observers;
	int generatedNumber;
	
	public EulerMachine() {
	generatedNumber=0;
	observers=new ArrayList<>();
	}

	@Override
	public void addObserver(Observer obs) {
			observers.add((PlayerStrategy)obs);
		
	}

	@Override
	public void deleteObservers() {
		observers.clear();
		
	}


	public void notifyObservers() {
		for(PlayerStrategy o:observers){
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
