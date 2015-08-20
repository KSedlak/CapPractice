package com.capgemini.Euler298;

public interface Observable {



	public void addObserver(Observer obs);

	public void deleteObservers();

	public void notifyObservers();

}
