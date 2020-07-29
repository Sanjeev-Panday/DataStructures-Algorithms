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
    public static boolean isSorted(Comparable [] arr,int lo, int hi) {
        for(int i = lo; i < hi; i++) {
            if(!isLess(arr[i],arr[i+1])) return false;
        }
        return true;
    }
    public static void copy(Comparable[] source, Comparable[] target) {
        assert target.length >= source.length;
        System.arraycopy(source,0,target,0,source.length);
    }
}
