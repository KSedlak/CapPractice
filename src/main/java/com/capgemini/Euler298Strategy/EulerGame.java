package com.capgemini.Euler298Strategy;

public class EulerGame {

	public static void main(String[] args) {
		
		EulerMachine em =new EulerMachine();
		
		Larry p1= new Larry();
		Robin p2 = new Robin();
		
		em.addObserver(p1);
		em.addObserver(p2);
		
		for(int i=0;i<50;i++){
			em.callNumber();
		}
		
		int larryScore=p1.getPoints();
		int robinScore=p2.getPoints();
	double result=Math.abs(larryScore-robinScore);
	System.out.println(result);
}
}