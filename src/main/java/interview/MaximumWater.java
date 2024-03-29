package interview;

public class MaximumWater {
    public static int maximumWater(int[] arr) {
        if (arr == null) return 0;
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                maxArea = Math.max(Math.min(arr[i], arr[j]) * (j - i), maxArea);
            }
        }
        return maxArea;
    }

    public static int maximumWaterV2(int[] arr) {
        if (arr == null) return 0;
        int maxArea = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            int newArea = height * width;
            maxArea = Math.max(maxArea, newArea);
            if (arr[left] < arr[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
