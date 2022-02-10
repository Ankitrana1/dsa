package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination1 {

    /*
    https://leetcode.com/problems/combination-sum/
    Given an array of distinct integers candidates and a target integer target,
    return a list of all unique combinations of candidates where the chosen numbers sum to target.
    You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times.
    Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     */

    private static void combinations(int index, int[] arr, int target, List<Integer> temp, List<List<Integer>> ans, int size) {
        if(index == size) {
            if(target == 0)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(arr[index] <= target) {
            temp.add(arr[index]);
            combinations(index, arr, target - arr[index], temp, ans, size);
            temp.remove(temp.size()-1);
        }
        combinations(index+1, arr, target, temp, ans, size);
    }

    public static void main(String[] args) {
        int[] arr = {2,6,3,7};
        List<List<Integer>> ans = new ArrayList<>();
        combinations(0, arr, 7, new ArrayList<>(), ans, arr.length);

        for(List<Integer> al : ans) {
            for(int i : al) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
