package algorithms.sorting;

import static algorithms.util.Helper.isLess;
import static algorithms.util.Helper.swap;

/**
 * Selection sort works by selecting the next minimum index and swapping that with current one
 */
public class Selection {

    public static void sort(Comparable[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j = i; j < arr.length; j++) {
                if(isLess(arr[j] ,arr[min])) min = j;
            }
            swap(arr, i, min);
        }
    }

}
