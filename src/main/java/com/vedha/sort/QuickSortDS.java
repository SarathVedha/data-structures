package com.vedha.sort;

import java.util.Arrays;

public class QuickSortDS {

    // Quick Sort Algorithm Best for Array
    // Time Complexity: O(n log n) - Best, Average, Worst Case Scenario
    // Space Complexity: O(log n) - Best, Average, Worst Case Scenario (Recursion) - In-Place
    public static int[] quickSortASC(int[] arr) {

        sortASC(arr, 0, arr.length - 1);

        return arr;
    }

    private static void sortASC(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int pivot = arr[(start + end) >> 1];

        while (start <= end) {

            while (arr[start] < pivot) {

                start++;
            }

            while (arr[end] > pivot) {

                end--;
            }

            if (start <= end) {

                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        sortASC(arr, low, end);
        sortASC(arr, start, high);
    }

    public static int[] quickSortDESC(int[] arr) {

        sortDESC(arr, 0, arr.length - 1);

        return arr;
    }

    private static void sortDESC(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int pivot = arr[(start + end) >> 1];

        while (start <= end) {

            while (arr[start] > pivot) {

                start++;
            }

            while (arr[end] < pivot) {

                end--;
            }

            if (start <= end) {

                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        sortDESC(arr, low, end);
        sortDESC(arr, start, high);
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        System.out.println("QuickSortDS.quickSortASC(arr) = " + Arrays.toString(QuickSortDS.quickSortASC(arr)));

        int[] arr2 = {5, 3, 8, 4, 2, 7, 1, 10};
        System.out.println("QuickSortDS.quickSortDESC(arr2) = " + Arrays.toString(QuickSortDS.quickSortDESC(arr2)));
    }
}
