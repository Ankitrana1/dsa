package array;

import java.util.Arrays;

public class MinimizeMaxDifference {

    //Minimize the maximum difference between heights bby either inc/dec the height by K(only once)
    private static int minDiffBetweenHeights(int[] arr, int k) {
        Arrays.sort(arr);

        int min = arr[0] + k, max = arr[arr.length-1] - k;
        int ans = max - min;

        for(int i = 1; i< arr.length; i++) {
            min = Math.min(min, arr[i] - k);
            max = Math.max(max, arr[i-1] + k);

            if(min < 0) continue;
            ans = Math.min(ans, max - min);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {3, 9, 16, 12, 20};
        System.out.println(minDiffBetweenHeights(arr, 3));
    }
}

