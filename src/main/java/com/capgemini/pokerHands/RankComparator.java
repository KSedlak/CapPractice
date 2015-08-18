package com.capgemini.pokerHands;

import java.util.Comparator;
import java.util.Map;

public class RankComparator implements Comparator<Map.Entry<Rank, Integer>> {
	
	public RankComparator(){}
	

	   public int compare(Map.Entry e1, Map.Entry e2) {
		    int val1= (int) e1.getValue();
		    int val2 = (int) e2.getValue();
		    System.out.println(val1);
		    
		    if(val1>val2){
		    	return -1;
		    }
		    if(val1<val2){
		    	return 1;
		    }
		    else{
		       	Rank r1=( Rank)e1.getKey();
			   	Rank r2=( Rank)e2.getKey();
			   	return r1.compareTo(r2);
		    }
		
		   }

}

