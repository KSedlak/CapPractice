package com.capgemini.pokerHands;


import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;


public class Hand implements Comparable<Hand> {
	private LinkedHashMap<Rank, Integer> deck;
	private LinkedHashMap<String, Integer> mapValues;
	private Suit suit;
	private boolean sameColor;
	private boolean con;
	private static int maxCardsInHand = 5;
	private String handRepresentation;

	public Hand() {
		deck = new LinkedHashMap();
		sameColor = true;
		con = false;
		initMapValues();

	}

	public void putToMap(Card c) {
		int tmp = 0;
		Rank key = c.rank;
		if (deck.containsKey(key)) {
			tmp = deck.get(key);
			deck.put(key, tmp + 1);
		} else {
			deck.put(key, 1);
		}
	}

	public void addToHand(Card c) {
		if (deck.isEmpty()) {
			suit = c.suit;
		}
		if (c.suit != this.suit) {// [TODO] KS equals
			sameColor = false;
		}
		putToMap(c);

		if (cardInHand() == maxCardsInHand) {
			deck =sortByValues(deck);
			handRepresentation = makeStringRepresentation();
			con = isConsecutive();
			if (handRepresentation.length() != maxCardsInHand) {
				sameColor = false;
				con = false;
			}

		}
	}

	public boolean isConsecutive() {

		Iterator<Rank> hIterator = deck.keySet().iterator();
		Rank a= hIterator.next();
		do{
		Rank b = hIterator.next();	
		if(a.ordinal()-b.ordinal()!=1){
			return false;
		}
		a=b;
		}while(hIterator.hasNext());
	
		return true;
	}

	public String makeStringRepresentation() {
		String buff = "";

		for (Rank r : deck.keySet()) {
			buff = buff + deck.get(r);
		}
		return buff;

	}

	@Override
	public int compareTo(Hand o) {
		int value1 = mapValues.get(this.handRepresentation+this.sameColor+this.con);
		int value2 = mapValues.get(o.handRepresentation+o.sameColor+o.con);	
		
		if (value1 > value2) 
			return 1;
		
		if (value1 < value2) 
			return 0;

			return compareSameHand(this, o);
	}

	public int compareSameHand(Hand h1, Hand h2) {
		Object[] h1Ranks = h1.getDeck().keySet().toArray();
		Object[] h2Ranks = h2.getDeck().keySet().toArray();
		Rank r1;
		Rank r2;
		for (int i =0; i <h1Ranks.length ; i++) {
			r1 = (Rank) h1Ranks[i];
			r2 = (Rank) h2Ranks[i];

			if (r1.ordinal() > r2.ordinal()) 
				return 1;
			
			if (r1.ordinal() < r2.ordinal()) 
				return 0;
		}
		return 0;
	}

	public int cardInHand() {
		int sum = 0;
		for (Rank r : deck.keySet()) {
			sum = sum + deck.get(r);
		}
		return sum;
	}

	public boolean isSameColor() {
		return sameColor;
	}

	public void setSameColor(boolean sameColor) {
		this.sameColor = sameColor;
	}

	public boolean isCon() {
		return con;
	}

	public void setCon(boolean con) {
		this.con = con;
	}


	public static <Rank extends Comparable,Integer extends Comparable> LinkedHashMap<Rank,Integer> sortByValues(LinkedHashMap<Rank,Integer> map){
	    LinkedList<Entry<Rank, Integer>> entries = new LinkedList<Map.Entry<Rank,Integer>>(map.entrySet());

	    Collections.sort(entries, new Comparator<Entry<Rank,Integer>>() {


			@Override
			public int compare(Entry<Rank, Integer> o1, Entry<Rank, Integer> o2) {
				int val=(int) o1.getValue();
				int val2=(int) o2.getValue();
				if(val==val2){
					return o1.getKey().compareTo(o2.getKey())*(-1);
				}
				return o1.getValue().compareTo(o2.getValue())*(-1);
				
			}
	    });


	    LinkedHashMap< Rank, Integer> sorted = new LinkedHashMap<>();
	    	String buff="";
	    for(Map.Entry<Rank,Integer> entry: entries){
	        sorted.put(entry.getKey(), entry.getValue());
	       buff=buff+entry.getValue();
	    }
	 
	    return sorted;
	}

	

	public LinkedHashMap<Rank, Integer> getDeck() {
		return deck;
	}

	public void setDeck(LinkedHashMap<Rank, Integer> deck) {
		this.deck = deck;
	}
	public void initMapValues(){
		mapValues=new LinkedHashMap<>();
		for(PossibleValues p: PossibleValues.values()){
			mapValues.put(p.getCombination()+p.getColorSame()+p.getCon(), p.ordinal());
		}
		
	}
}