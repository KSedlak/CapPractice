package com.sexypairs;

import java.util.ArrayList;

public class SexyPairs {
	ArrayList<Pair> pairList;

	public SexyPairs() {
		pairList = new ArrayList<>();
	}

	public void calculatePairsFermat(int n) {
		long timeStart=System.currentTimeMillis();
			for(int i=2;i+6<=n;i++){
			if (isPrimeNumberFermat(i) && isPrimeNumberFermat(i + 6)) {
				pairList.add(new Pair(i, i + 6));
			}
		}
			long timeEnd=System.currentTimeMillis();
			System.out.println("FermatCalculation time:"+(timeEnd-timeStart));
	}
	public void calculatePairs(int n) {
		long timeStart=System.currentTimeMillis();
			for(int i=2;i+6<=n;i++){
			if (isPrimeNumber(i) && isPrimeNumber(i + 6)) {
				pairList.add(new Pair(i, i + 6));
			}
		}
			long timeEnd=System.currentTimeMillis();
			System.out.println("Standard Calculation time:"+(timeEnd-timeStart));
	}
	public ArrayList<Pair> getPairsList() {
		return pairList;
	}

	public boolean isPrimeNumber(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isPrimeNumberFermat(int n) {
			if(!fermatTest(2, n)){
				return false;
			}
		return true;
	}
	
	public boolean fermatTest(int a, int p){
	int left=(int)Math.pow(a, p-1)%p;
	return left==1;
	}

	public void print(){
		for(Pair p:pairList){
			System.out.println(p);
		}
		
	}
}
