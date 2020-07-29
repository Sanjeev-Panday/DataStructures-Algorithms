package algorithms.util;

public class Helper {
    public static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void swap(Comparable [] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean isSorted(Comparable [] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            if(!isLess(arr[i],arr[i+1])) return false;
        }
        return true;
    }
}
