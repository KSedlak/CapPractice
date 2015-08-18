package com.capgemini.placeToSplit;

/**
 * Given a non-empty array, return true if there is a place to split the array
 * so that the sum of the numbers on one side is equal to the sum of the numbers
 * on the other side. Example: {{{ canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false canBalance({10, 10}) → true }}}
 */
public final class PlaceToSplit {

	PlaceToSplit() {

	}

	public static boolean canBalance(int[] nums) {
		int left = 0;
		int right = 0;

		if (nums.length > 1) {

			for (int i = 0; i < nums.length; i++) {
				left = left + nums[i];
				right = 0;
				for (int j = nums.length-1; j > i; j--) {
					right = right+nums[j];
				}
				if (left == right) {
					return true;
				}

			}

		}
		return false;
	}

	}




