package com.other.ArmstrongNumbers;

public class ArmstrongNumbers {
	
	
	public void printXArmstrongNumbers(int border){
		for(int i=0;i<border;i++){
			if(isArmstrong(i)){
				System.out.println(i);
			}
		}
	}
	public boolean isArmstrong(int input){
		String temp = input+"";
		int sum=0;
		for(int i=0;i<temp.length();i++){
		int k=Integer.parseInt(temp.substring(0+i,1+i));
		sum=(int) (sum+Math.pow(k, 3));
		}
		if(sum==input){
			return true;
		}
		else{
			return false;
		}
		
		
		
	}

}
