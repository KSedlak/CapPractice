package com.capgemini.Euler298Strategy;

public interface Observable {



	public void addObserver(Observer obs);

	public void deleteObservers();

	public void notifyObservers();

}
