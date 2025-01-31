package com.vedha.sort;

import java.util.Arrays;

public class InsertionSortDS {

    // InsertionSort time complexity is O(n^2) in the worst case scenario and O(n) in the best case scenario and space complexity is O(1)
    public static int[] sortASC(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // Compare the current element with the previous elements
            for (int j = i; j > 0; j--) {

                if (arr[j] < arr[j - 1]) {

                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {

                    // If the current element is greater than the previous element, then break the loop
                    break;
                }
            }
        }

        return arr;
    }

    public static int[] sortDesc(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // Compare the current element with the previous elements
            for (int j = i; j > 0; j--) {

                if (arr[j] > arr[j - 1]) {

                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {

                    // If the current element is less than the previous element, then break the loop
                    break;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 4, 5, 6, 1, 3};
        System.out.println("Arrays.toString(sortASC(arr)) = " + Arrays.toString(sortASC(arr)));

        int[] arr2 = {5, 2, 4, 5, 6, 1, 3};
        System.out.println("Arrays.toString(sortDesc(arr2)) = " + Arrays.toString(sortDesc(arr2)));
    }
}
