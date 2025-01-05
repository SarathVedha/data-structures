/**
 * 
 */
package com.vedha.search;

import java.util.Arrays;

/**
 * @author sarath.perumal
 *
 */
public class LinearSearchDS {

	// TimeComplexity for linear search on by one so worst case O(1) and best case
	// is O(1) if the target element in first position.
	// for both sorted and unsorted array.

	public static int find(int[] arr, int value) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == value) {

				return i;
			}
		}
		return -1;

	}

	public static boolean contains(int[] arr, int target) {

        for (int j : arr) {

            if (j == target) {

                return true;
            }
        }

		return false;
	}

	public static int find(String arg, char target) {

		for (int i = 0; i < arg.length(); i++) {

			if (arg.charAt(i) == target) {

				return i;
			}
		}

		return -1;
	}

	public static boolean contains(String arg, char target) {

		for (int i = 0; i < arg.length(); i++) {

			if (arg.charAt(i) == target) {

				return true;
			}
		}

		return false;
	}

	public static int[] find(int[][] arrs, int target) {

		for (int row = 0; row < arrs.length; row++) {

			for (int coln = 0; coln < arrs[row].length; coln++) {

				if (arrs[row][coln] == target) {

					return new int[] { row, coln };
				}
			}

		}

		return new int[] { -1, -1 };
	}

	public static boolean contains(int[][] arrs, int target) {

        for (int[] arr : arrs) {

            for (int i : arr) {

                if (i == target) {

                    return true;
                }
            }
        }

		return false;
	}

	public static void main(String[] args) {

//		int[] arr = new int[] { 1, 2, 3 };
		int[] arr = { 1, 2, 3 };

		int find = LinearSearchDS.find(arr, 0);
		System.out.println(find);

		boolean contains = LinearSearchDS.contains(arr, 4);
		System.out.println(contains);

		String s = "Vedha";
		int find2 = LinearSearchDS.find(s, 'a');
		System.out.println(find2);

		boolean contains2 = LinearSearchDS.contains(s, 'V');
		System.out.println(contains2);

//		int[][] arrs = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] arrs = { { 1, 2 }, { 3, 4 } };
		int[] find3 = LinearSearchDS.find(arrs, 4);
		System.out.println(Arrays.toString(find3));

		boolean contains3 = LinearSearchDS.contains(arrs, 6);
		System.out.println(contains3);

	}

}
