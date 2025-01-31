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

    // Time Complexity for Selection Sort is O(n2) because of two loops and space complexity is O(1)
    public static void sortAsc(int[] array) {

        for (int i = 0; i < array.length; i++) { // fix the position

            int minValue = array[i];

            int minIndex = i;

            // get minimum value
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
    }

    public static int[] sortDesc(int[] array) {

        for (int i = 0; i < array.length; i++) { // fix position

            int maxVal = array[i];
            int maxIndex = i;

            // get max value
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

        int[] arr = {10, 3, 26, 5, 15, 22};
        SelectionSortDS.sortAsc(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {10, 3, 26, 5, 15, 22};
        System.out.println(Arrays.toString(arr2) + ", HashCode: " + arr2.hashCode());
        System.out.println(Arrays.hashCode(arr2)); // hashcode of array internal elements (not the array object)
        System.out.println(System.identityHashCode(arr2)); // hashcode of an array object (not the internal elements)

        int[] sorted = SelectionSortDS.sortDesc(arr2);
        System.out.println(Arrays.toString(sorted) + ", HashCode: " + sorted.hashCode());
        System.out.println(Arrays.hashCode(sorted));
        System.out.println(System.identityHashCode(sorted));
    }

}
