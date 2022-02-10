package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination2 {
    /*
    https://leetcode.com/problems/combination-sum-ii/
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.
     */

    private static void combinations(int index, int[] arr, int target, List<Integer> temp, List<List<Integer>> ans) {
        if(target == 0){
            ans.add(new ArrayList<>(temp));
        }
        for (int i = index; i < arr.length; i++) {
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            temp.add(arr[i]);
            combinations(i+1, arr, target - arr[i], temp, ans);
            temp.remove(temp.size()- 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        combinations(0, arr, 8, new ArrayList<>(), ans);

        for(List<Integer> al : ans) {
            for(int i : al) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
