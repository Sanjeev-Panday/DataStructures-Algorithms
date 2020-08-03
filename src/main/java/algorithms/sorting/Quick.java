package algorithms.sorting;

import algorithms.util.Helper;

import static algorithms.util.Helper.*;

public class Quick {

    private static int partition(final Comparable[] arr, final int lo, final int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {

            //increment i until we find an element greater than arr[pivot]

            while (isLess(arr[++i],arr[lo])) if(i == hi)  break;

            // Decrement j util we find an element smaller than arr[pivot]
            while (!isLess(arr[--j],arr[lo])) {
                // This if check can be avoided as our starting pivot is lo
                // Hence the while condition will break at least when j will become 0 in worst case.
                if (j == lo) break;

            }
            if (i >= j) break;
            swap(arr,i,j);
        }
        swap(arr,lo,j);
        return j;
    }

    public static void sort(final Comparable[] arr) {
        shuffle(arr);
        final int lo = 0;
        final int hi = arr.length - 1;
        sort(arr,lo,hi);
    }

    private static void sort(final Comparable[] arr,final int lo, final int hi) {
        if (lo >= hi) return;
        int j = partition(arr,lo,hi);
        // Sort the left subarray
        sort(arr,lo,j-1);
        // Sort the right subarray
        sort(arr,j+1,hi);
    }
}
