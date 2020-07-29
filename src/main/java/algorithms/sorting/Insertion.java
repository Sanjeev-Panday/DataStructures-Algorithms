package algorithms.sorting;

import static algorithms.util.Helper.isLess;
import static algorithms.util.Helper.swap;

/**
 * Insertion sort works by inserting the current element in the already sorted ( left ) sub array
 */
public class Insertion {
    public static void sort(Comparable[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j > 0 && isLess(arr[j] ,arr[j-1]); j--) {
                swap(arr, j, j-1);
            }

        }
    }
}
