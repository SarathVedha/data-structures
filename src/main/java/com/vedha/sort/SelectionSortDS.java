/**
 * 
 */
package com.vedha.sort;

import java.util.Arrays;

/**
 * @author sarath.perumal
 *
 */
public class SelectionSortDS {

	// Time Complexity for Selection Sort is O(n2) because of two loops
	public static int[] sortAsc(int[] array) {

		for (int i = 0; i < array.length; i++) { // fix the position

			int minValue = array[i];
			int minIndex = i;

			for (int j = i; j < array.length; j++) { // get minimum value

				if (array[j] < minValue) {

					minValue = array[j];
					minIndex = j;
				}
			}

			// swap
			int temp = array[i];
			array[i] = minValue;
			array[minIndex] = temp;
		}
		return array;
	}

	public static int[] sortDesc(int[] array) {

		for (int i = 0; i < array.length; i++) { // fix position

			int maxVal = array[i];
			int maxIndex = i;

			for (int j = i; j < array.length; j++) { // get max value

				if (array[j] > maxVal) {

					maxVal = array[j];
					maxIndex = j;
				}
			}

			// swap
			int temp = array[i];
			array[i] = maxVal;
			array[maxIndex] = temp;
		}

		return array;
	}

	public static void main(String[] args) {

		int[] arr = { 10, 3, 26, 5, 15, 22 };
		SelectionSortDS.sortAsc(arr);
		System.out.println(Arrays.toString(arr));

		int[] arr2 = { 10, 3, 26, 5, 15, 22 };
		SelectionSortDS.sortDesc(arr2);
		System.out.println(Arrays.toString(arr2));
	}

}
