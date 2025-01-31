package com.vedha.sort;

import java.util.Arrays;

public class MergeSortDS {

    // MergeSort is a Divide and Conquer algorithm.
    // Best for sorting-linked lists.
    // Time Complexity: O(n log n) in all cases (worst, average and best),
    // as merge sort always divides the array into two halves and takes linear time to merge two halves.
    // It requires O(n) extra space for the temporary arrays.
    public static int[] sortAsc(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length >> 1;

        int[] leftHalf = sortAsc(Arrays.copyOfRange(arr, 0, mid));
        int[] rightHalf = sortAsc(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeAsc(leftHalf, rightHalf);
    }

    private static int[] mergeAsc(int[] left, int[] right) {

        int[] joined = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] < right[j]) {

                joined[k++] = left[i++];
            } else {

                joined[k++] = right[j++];
            }
        }

        while (i < left.length) {

            joined[k++] = left[i++];
        }

        while (j < right.length) {

            joined[k++] = right[j++];
        }

        return joined;
    }

    public static int[] optimizedSortASC(int[] arr) {

        optimizedSortASC(arr, 0, arr.length);

        return arr;
    }

    private static void optimizedSortASC(int[] arr, int start, int end) {

        if (end - start == 1) {

            return;
        }

        int mid = (start + end) >> 1;

        optimizedSortASC(arr, start, mid);
        optimizedSortASC(arr, mid, end);

        optimizedMergeASC(arr, start, mid, end);
    }

    private static void optimizedMergeASC(int[] arr, int start, int mid, int end) {

        int[] joined = new int[end - start];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {

            if (arr[i] < arr[j]) {

                joined[k++] = arr[i++];
            } else {

                joined[k++] = arr[j++];
            }
        }

        while (i < mid) {

            joined[k++] = arr[i++];
        }

        while (j < end) {

            joined[k++] = arr[j++];
        }

//        for (int l = 0; l < joined.length; l++) {
//
//            arr[start + l] = joined[l];
//        }

        System.arraycopy(joined, 0, arr, start, joined.length);
    }

    public static int[] optimizedSortDESC(int[] arr) {

        optimizedSortDESC(arr, 0, arr.length);

        return arr;
    }

    private static void optimizedSortDESC(int[] arr, int start, int end) {

        if (end - start == 1) {

            return;
        }

        int mid = start + end >> 1;

        optimizedSortDESC(arr, start, mid);
        optimizedSortDESC(arr, mid, end);

        optimizedMergeDESC(arr, start, mid, end);
    }

    private static void optimizedMergeDESC(int[] arr, int start, int mid, int end) {

        int[] joined = new int[(end - start)];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {

            if (arr[i] > arr[j]) {

                joined[k++] = arr[i++];
            } else {

                joined[k++] = arr[j++];
            }
        }

        while (i < mid) {

            joined[k++] = arr[i++];
        }

        while (j < end) {

            joined[k++] = arr[j++];
        }

//        for (int l = 0; l < joined.length; l++) {
//
//            arr[start + l] = joined[l];
//        }

        System.arraycopy(joined, 0, arr, start, joined.length);
    }


    public static void main(String[] args) throws InterruptedException {

        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10, 6, 5, 9};
        System.out.println("MergeSortDS.sortAsc(arr) = " + Arrays.toString(MergeSortDS.sortAsc(arr)));

        System.out.println("MergeSortDS.optimizedSortASC(arr) = " + Arrays.toString(MergeSortDS.optimizedSortASC(arr)));

        int[] arr2 = {5, 3, 8, 4, 2, 7, 1, 10, 6, 5, 9};
        System.out.println("MergeSortDS.optimizedSortDESC(arr) = " + Arrays.toString(MergeSortDS.optimizedSortDESC(arr2)));
    }
}
