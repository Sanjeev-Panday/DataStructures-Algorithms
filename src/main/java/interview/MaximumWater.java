package interview;

public class MaximumWater {
    public static int maximumWater(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                maxArea = Math.max(Math.min(arr[i], arr[j]) * (j - i), maxArea);
            }
        }
        return maxArea;
    }

}
