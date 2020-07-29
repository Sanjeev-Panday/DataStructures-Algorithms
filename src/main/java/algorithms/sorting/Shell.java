package algorithms.sorting;

import static algorithms.util.Helper.isLess;
import static algorithms.util.Helper.swap;

/**
 * Shell sort works by inserting the current element in the already sorted ( left ) sub array
 * Different between shell sort and insertion sort is that in shell sort far away items are exchanged iteratively.
 */
public class Shell {
    public static void sort(Comparable[] arr) {
        int h = 0;
        int N = arr.length;
        while( h < N/3)  h = 3 * h +1;
        while( h>=1) {
            for(int i = h; i < arr.length; i++) {
                for(int j = i; j >= h && isLess(arr[j] ,arr[j-h]); j -= h) {
                    swap(arr, j, j-h);
                }
            }
            h = h/3;
        }

    }
}