package algorithms.sorting;

import static algorithms.util.Helper.*;

/**
 * Merge sort works by merging two sorted array into one
 * It follows the Divide and conquer paradigm. The algorithm first divides the array in smaller sub-
 * arrays until each sub array is of size 1 (which is then implicitly sorted). Next is merges all the
 * sub-arrays one after another.
 */
public class Merge {
    public static void sort(Comparable [] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        Comparable[] aux = new Comparable[arr.length];
        sort(aux,lo,hi,arr);

    }
    private static void sort(Comparable[] aux,int lo,int hi, Comparable[] arr){
        // Base condition for recursive call.
        if(lo >= hi) {
            return;
        }
        int mid = (lo+hi)/ 2;
        //Recursive calls
        // Divide the left sub array
        sort(aux,lo,mid,arr);
        // Divide the right sub array
        sort(aux,mid+1,hi,arr);
        merge(aux, lo, mid, hi, arr);
    }
    private static void merge(Comparable[] aux, int lo, int mid, int hi, Comparable[] arr) {
        // we will be merging array aux[lo] ... aux[mid] and aux[mid+1] ... aux[hi] to arr
        assert isSorted(arr,lo,mid);
        assert isSorted(arr,mid+1,hi);
        for(int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }
        int i = lo;
        int j = mid+1;
        for (int k = i; k <= hi; k++) {
            if (i > mid ) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (isLess(aux[i],aux[j])) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }

    }
}
