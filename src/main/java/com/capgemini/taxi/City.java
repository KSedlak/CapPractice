package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.*;

public class City {
	private User me;
	private ArrayList<Taxi> listOfTaxi;
	private int maxNumberOFTaxi;
	private int maxResultList;

	public City(double uLat, double uLong, int maxR, int maxN, int initTaxiNumber) {
		me = new User(new Position(uLat, uLong));
		maxNumberOFTaxi = maxN;
		maxResultList = maxR;
		listOfTaxi = new ArrayList<Taxi>();
		for (int i = 0; i < initTaxiNumber; i++) {
			addTaxiToCity(new Taxi(getRandomPositionFromUserPosition(me.pos),i));
		}
		randomizeAvability();

	}

	public static double calculateDistance(User u, Taxi t) {
		double earthRadius = 6371.0d; // KM: use mile here if you want mile
					// result
		Position user = u.getPos();
		Position taxi = t.getPos();
	//	System.out.println(u.pos + " TAXI: "+t.pos);
		double dLat = toRadian(user.getpLat() - taxi.getpLat());
		double dLng = toRadian(user.getpLong()- taxi.getpLong());

		double a = Math.pow(Math.sin(dLat / 2), 2)
				+ Math.cos(toRadian(user.getpLat())) * Math.cos(toRadian(taxi.getpLat())) * Math.pow(Math.sin(dLng / 2), 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return earthRadius * c * 1000;
	}

	public static double toRadian(double degrees) {
		return (degrees * Math.PI) / 180.0d;
	}

	public ArrayList<Taxi> getTaxiInRadius() {
		double dist = 0;
		ArrayList<Taxi> result = new ArrayList<Taxi>();
		for (Taxi t : listOfTaxi) {
			dist = calculateDistance(me, t); // calc distance
			t.setDistanceForCustomer(dist); // set distance for later sort
			
			if (dist < 1000) { // if distance <<1km				
				result.add(t); // add taxi
			}
	
		}
		Collections.sort(result);
		return result;
	}

	public void addTaxiToCity(Taxi t) {
		if (listOfTaxi.size() + 1 > maxNumberOFTaxi) {
			// too many taxi
		} else {
			listOfTaxi.add(t);
		}
	}

	public Position getRandomPositionFromUserPosition(Position u) {
		double tLat = 0;
		double temp;
		double tLon = 0; // 50,0359
		double rand;
		rand = (int) (Math.random() * 100);
		temp=rand/10000;
		tLat = u.getpLat() + rand / 1000;
		rand = (int) (Math.random() * 100);
		tLon = u.getpLong() + rand / 1000;
		return new Position(tLat, tLon);
	}
	
	public void randomizeAvability(){
		int rand;
		for(Taxi t:listOfTaxi){
			rand = (int) (Math.random() * 2);
			if(rand==0){t.setAvability(false);}
			else{
				t.setAvability(true);
				}
			}	
		}
	public void randomizePositionsForNextTick(){		
		for(Taxi t:listOfTaxi){
			t.setPos(getRandomPositionFromUserPosition(me.pos));
			}	
		}
	
	public void nextTickOfTime(){
		randomizeAvability();
		randomizePositionsForNextTick();
	}
	
	public String getNearestTaxiResult(){
		String result="";
		ArrayList<Taxi> nearest = getTaxiInRadius();
		int count=0;
		for(Taxi t:nearest){
			result=result+t+"\n";
		
			count++;
		if(count==maxResultList){
			break;
		}
		}
		

		return result;
	}

}