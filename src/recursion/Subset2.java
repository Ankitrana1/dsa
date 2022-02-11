package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    /*
    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.
     */

    private static void subsets(int index, int[] arr, List<List<Integer>> ans, List<Integer> ds, int length) {
        ans.add(new ArrayList<>(ds));
        for(int i = index; i<length; i++) {
            if(i != index && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            subsets(i+1, arr, ans, ds, length);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2};
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        subsets(0, arr, ans, new ArrayList<>(), arr.length);
        for(List<Integer> l : ans) {
            for(int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
