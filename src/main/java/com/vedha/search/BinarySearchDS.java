/**
 * 
 */
package com.vedha.search;

/**
 * @author sarath.perumal
 *
 */
public class BinarySearchDS {

	// TimeComplecity for Binary Search is O(logn) because of half
	public static int find(int[] arg, int target) {

		int start = 0;
		int mid = 0;
		int last = arg.length - 1;
		boolean isDESC = false;

		if (arg[0] > arg[last]) {

			isDESC = true;
		}

		int i = 0;
		while (start <= last) {

			++i;
			mid = (start + last) >>> 1;
			int midVal = arg[mid];

			if (isDESC) {

				if (target > midVal) {

					last = mid - 1;
				} else if (target < midVal) {

					start = mid + 1;
				} else {

					System.out.println("Loop Count : " + i);
					return mid;
				}
			} else {

				if (target > midVal) {

					start = mid + 1;
				} else if (target < midVal) {

					last = mid - 1;
				} else {

					System.out.println("Loop Count : " + i);
					return mid;
				}
			}

		}

		System.out.println("Loop Count : " + i);
		return -1;

	}

	public static void main(String[] args) {

		int[] arg = { 8, 7, 6, 5, 4, 3, 2, 1 };
		int find = BinarySearchDS.find(arg, 4);
		System.out.println(find);

		System.out.println((2 + 4) >> 1); // its divided by 2 one time
		System.out.println((2 + 4) << 1); // its 6 * 2 one time
	}

}
