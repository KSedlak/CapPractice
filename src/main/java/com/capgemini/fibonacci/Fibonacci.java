package com.capgemini.fibonacci;

import java.util.ArrayList;

/**
 * Created by ldrygala on 2015-01-23. F1 F2 F3 F4 F5 F6 F7 F8 F9 F10 F11 F12 F13
 * F14 F15 F16 F17 F18 F19 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597
 * 2584 4181
 */
public class Fibonacci {

	public static long fib(int n) {

		long a = 1; // pierwszy wyraz
		int count = 2; /// licyba wyrazow
		long b = 1; // drugi wyraz
		long next = 0; // nastepny
		
		if (n <= 0) {
			System.out.println("Wrong value n");
			return 0;
		}
		if (n > 0 && n < 3) {
			return 1;
		}
		else{
	//		System.out.println(1);
	//		System.out.println(1);	
		
		while (count < n) {
			next = a + b;
			a = b;
			b = next;
			count++;
	//		System.out.println(next);
		}
		
		return next;
		}
		}
}
