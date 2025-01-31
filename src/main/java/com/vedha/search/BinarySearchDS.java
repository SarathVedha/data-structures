/**
 *
 */
package com.vedha.search;

import java.util.stream.IntStream;

/**
 * @author sarath.perumal
 *
 */
public class BinarySearchDS {

    // TimeComplexity for Binary Search is O(logn) because of half
    // for sorted array only because we are dividing the array into half.
    public static int find(int[] arg, int target) {

        int start = 0;
        int mid;
        int last = arg.length - 1;
        boolean isDESC = arg[0] > arg[last];

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

        // DESC Order Small Num
        int[] arg = {8, 7, 6, 5, 4, 3, 2, 1}; // loop count 4
        int find = BinarySearchDS.find(arg, 4);
        System.out.println("find = " + find);

        // ASC Order Large Num
        int[] array = IntStream.range(0, 10000).toArray();
//		System.out.println(Arrays.toString(array));
        int findValue = BinarySearchDS.find(array, 9991); // loop count 13
        System.out.println("findValue = " + findValue);

        int firstValue = BinarySearchDS.find(array, 0); // loop count 13 because of middle divide
        System.out.println("firstValue = " + firstValue);

//		System.out.println((2 + 4) >> 1); // it's divided by 2 one time
//		System.out.println((2 + 4) << 1); // it's 6 * 2 one time
    }

}
