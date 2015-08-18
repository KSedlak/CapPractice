package com.sexypairs;

public class Pair {
	int first;
	int second;
	
	public Pair(int a,int b){
		first=a;
		second=b;
	}
	
	public int getFirst() {

		return first;
	}

	public int getSecond() {

		return second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

}
