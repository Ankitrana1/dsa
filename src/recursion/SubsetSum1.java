package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSum1 {
    /*
    https://practice.geeksforgeeks.org/problems/subset-sums2234/1
    Given a list arr of N integers, print sums of all subsets in it.
    Note: Return all the element is increasing order.
     */
    private static void subsetSum(int index, int[] arr, int sum, List<Integer> ans, int n) {
        if(index == n) {
            ans.add(sum);
            return;
        }
        sum += arr[index];
        subsetSum(index+1, arr, sum, ans, n);
        sum -= arr[index];
        subsetSum(index+1, arr, sum, ans, n);
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        List<Integer> ans = new ArrayList<>();
        subsetSum(0, arr, 0, ans, arr.length);
        Collections.sort(ans);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}
