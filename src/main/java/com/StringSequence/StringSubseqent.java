package com.StringSequence;
/*
 * Given two strings, write a program that efficiently finds the longest common subsequence.
 * */
public class StringSubseqent {

	public String getLargestSubsequent(String string, String string2) {
		String [] temp=getShortest(string, string2);
		String a;
		String b;
		String max="";
		boolean found=false;
		int counter1=0;
		int counter2=0;
		for(int i=temp[0].length();i>0;i--){ ///check maximal length if not found --
			counter1=0;
			do{
				a=temp[0].substring(0+counter1, i+counter1); //check next part of short string
				counter2=0;
				do{
					b=temp[1].substring(0+counter2,a.length()+counter2); //in second string parts
					counter2++;
					if(a.equals(b)){
						max=a;
						found=true;
						break;
					}
				
				}while(a.length()+counter2<=temp[1].length());
				if(found){break;}				
				counter1++;
			}
			while(i+counter1<=temp[0].length());
			if(found){break;}
		}
		

		return max;
	
	
	}
	
	
	public String getLargestSubsequent2(String string, String string2) {
		String [] temp=getShortest(string, string2);
		String a;
		String b;
		String max="";
		boolean found=false;
		int counter1=0;
		int counter2=0;
		for(int i=temp[0].length();i>0;i--){ ///check maximal length if not found --
			counter1=0;
			do{
				a=temp[0].substring(0+counter1, i+counter1); //check next part of short string
				if(temp[1].contains(a)){
					max=a;
					found=true;
					break;
				}
					
				counter1++;
			}
			while(i+counter1<=temp[0].length());
			if(found){break;}
		}
		

		return max;
	
	
	}
	public String[] getShortest(String string, String string2){
		String [] res = new String[2];
		if(string.length()<=string2.length()){
			res[0]=string;
			res[1]=string2;
		}
		else{
			res[0]=string2;
			res[1]=string;
		}
		return res;
	}
}
