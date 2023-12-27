/**
 * 
 */
package com.vedha.sort;

import java.util.Arrays;

/**
 * @author sarath.perumal
 *
 */
public class BubbleSortDS {

	// BubbleSort time complexity is O(n2)and best case is O(n) but space complexity
	// is O(1)
	public static int[] sortAsc(int[] array) {

		for (int i = 1; i < array.length; i++) {

			boolean isSwapped = false;

			for (int j = 0; j < array.length - i; j++) {

				if (array[j] > array[j + 1]) {

					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isSwapped = true;
				}
			}

			if (!isSwapped) {

				return array;
			}
		}

		return array;
	}

	public static int[] sortDesc(int[] array) {

		for (int i = 1; i < array.length; i++) {

			boolean isSwapped = false;
			for (int j = 0; j < array.length - i; j++) {

				if (array[j + 1] > array[j]) {

					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isSwapped = true;

				}
			}

			if (!isSwapped) {

				return array;
			}
		}

		return array;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 5, 3 };
		BubbleSortDS.sortAsc(arr);
		System.out.println(Arrays.toString(arr));

		int[] arr2 = { 2, 1, 3, 5, 4 };
		BubbleSortDS.sortDesc(arr2);
		System.out.println(Arrays.toString(arr2));

	}

}
