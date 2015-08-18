package com.capgemini.coins;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.CipherInputStream;
import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Created by ldrygala on 2015-02-06.
 * <p/>
 * Consider N coins aligned in a row. Each coin is showing either heads or
 * tails. The adjacency of these coins is the number of adjacent pairs of coins
 * with the same side facing up.
 * <p/>
 * It must return the maximum possible adjacency that can be obtained by
 * reversing exactly one coin (that is, one of the coins must be reversed).
 * Consecutive elements of array A represent consecutive coins in the row. Array
 * A contains only 0s and/or 1s: 0 represents a coin with heads facing up; 1
 * represents a coin with tails facing up. For example, given array A consisting
 * of six numbers, such that:
 * <p/>
 * A[0] = 1 A[1] = 1 A[2] = 0-------------------- A[3] = 1!!!!!!!!!!!!!!!!!!!!
 * A[4] = 0 A[5] = 0
 * <p/>
 * the function should return 4. The initial adjacency is 2, as there are two
 * pairs of adjacent coins with the same side facing up, namely (0, 1) and (4,
 * 5). After reversing the coin represented by A[2], the adjacency equals 4, as
 * there are four pairs of adjacent coins with the same side facing up, namely:
 * (0, 1), (1, 2), (2, 3) and (4, 5), 0123456789 1100100100 and it is not
 * possible to obtain a higher adjacency. The same adjacency can be obtained by
 * reversing the coin represented by A[3].
 */
public class Coins {

	public static int solution(List<Integer> coins) {
		int max = 0;
		int temp = 0;
		ArrayList<Integer> changeIndexes = new ArrayList<Integer>();
		changeIndexes.add(0);
		changeIndexes.add(0);
		for (int i = 1; i <= coins.size() - 1; i++) {
			if (coins.get(i) != coins.get(i - 1)) {
				changeIndexes.add(i);

			}
		}
		changeIndexes.add(coins.size());
		changeIndexes.add(coins.size());
		/*
		 * System.out.println("Change"); for(Integer i:changeIndexes){
		 * System.out.println(i); }
		 */
		if (changeIndexes.size() == 4) {//all the same
			max = coins.size() - 1;
		} else {
			for (int i = 1; i < changeIndexes.size() - 2; i++) {

				if (changeIndexes.get(i + 1) - changeIndexes.get(i) == 1) {
					temp = (changeIndexes.get(i + 2) - changeIndexes.get(i))
							+ (changeIndexes.get(i) - changeIndexes.get(i - 1));

				} else {
					temp = changeIndexes.get(i + 1) - changeIndexes.get(i) + 1;
				}
				if (temp > max) {
					max = temp;
				}
			}
		}

		return max;
	}

	public static void stringToList(List list, String s) {
		for (int i = 0; i < s.length(); i++) {
			list.add(Integer.parseInt(s.charAt(i) + ""));
		}
	}

}
