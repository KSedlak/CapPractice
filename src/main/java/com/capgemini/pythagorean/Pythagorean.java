
package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52. There exists
 * exactly one Pythagorean triplet for which a + b + c = 1000. Find the product
 * abc.
 */
public class Pythagorean {
	int a;
	int b;
	int c;

	public void find(int x) {
		long timeStart = System.currentTimeMillis();
		double c;
		int sum = 0;
		for (int i = 1; i < x; i++) {
			for (int j = i + 1; j < x; j++) {
				c = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
				if ((i + j + c) == 1000) {
					a = i;
					b = j;
					this.c = (int) c;
					long timeEnd = System.currentTimeMillis();
					System.out.println(a + " " + b + " " + this.c + " found in: " + (timeEnd - timeStart) + " ms");
					break;
				}

			}

		}
	}

	public void find2(int x) {
		long timeStart;
		double c;
		int sum = 0;
		long timeEnd = System.currentTimeMillis();
		for (int i = 1; i < x / 2; i++) {
			double b = (x * (2 * i - x)) / (2 * (i - x));
			if (i > b) {
				break;
			}
			c = Math.sqrt(Math.pow(i, 2) + Math.pow(b, 2));
			if (i + b + c == x) {
				this.a = i;
				this.b = (int) b;
				this.c = (int) c;
				timeStart = System.currentTimeMillis();
				System.out.println(a + " " + b + " " + this.c + " found in: " + (timeStart - timeEnd) + " ms");
				break;
			}
		}
	}

	private boolean checkConditionOne(int a, int c) {
		return a < c;
	}

	private boolean checkSquareCondition(int a, int b, int c) {
		return (Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2);
	}

	private boolean checkNaturalCondition(int a, int b, int c) {
		return a > 0 && c > 0;
	}

	private boolean checkRest(double a) {
		return (a - (int) a) == 0;
	}
}
