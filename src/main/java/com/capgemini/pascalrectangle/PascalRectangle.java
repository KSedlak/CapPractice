package com.capgemini.pascalrectangle;

/**
 * Created by ldrygala on 2015-01-23. 0 1 1 1 1 2 1 2 1 3 1 3 3 1 4 1 4 6 4 1 5
 * 1 5 10 10 5 1 6 1 6 15 20 15 6 1 7 1 7 21 35 35 21 7 1 8 1 8 28 56 70 56 28 8
 * 1 9 1 9 36 84 126 126 84 36 9 1
 */
public class PascalRectangle {
	private int[][] tab;

	public long pascal(int c, int r, boolean print) {
		tab = new int[r + 1][];

		for (int i = 0; i < r + 1; i++) {// init table
			tab[i] = new int[r + 1 - i];
		}

		for (int i = 0; i < tab.length; i++) { // make pascal triangle
			for (int j = 0; j < tab[i].length; j++) {
				if (i == 0 || j == 0) {
					tab[i][j] = 1;
				} else {
					tab[i][j] = tab[i - 1][j] + tab[i][j - 1];
				}
			}
		}

		if (c - r > 1) { // column validation
			System.out.println("Ten wiersz nie posiada tylu kolumn, podaj inne wspolrzedne");
			return 0;
		}

		else {
			int result = tab[c - 1][r + 1 - c];

			// print
			if (print) {
				printTablePascal();
				
				printTriangle();

			}
			return result;
		}
	}

	private void printTriangle() {
		String buff;
		for (int k = 0; k < tab.length; k++) {
			buff = " ";
			for (int i = k; i < tab.length - 1; i++) {
				buff = buff + " ";
			}
			for (int s = 0; s <= k; s++) {
				buff = buff + " " + tab[k - s][s];
			}

			for (int i = k; i < tab.length - 1; i++) {
				buff = buff + " ";
			}
			System.out.println(buff);
		}
		System.out.println();
	}

	private void printTablePascal() {
		String buff = "";
		for (int i = 0; i < tab.length; i++) {
			buff = "";
			for (int j = 0; j < tab[i].length; j++) {
				buff = buff + " | " + tab[i][j];
			}
			System.out.println(buff);
		}
		System.out.println();
	}

}
