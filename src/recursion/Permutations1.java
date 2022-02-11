package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations1 {
    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
     */

    private static void permute(int[] arr, List<List<Integer>> ans, List<Integer> ds, boolean[] check) {
        if(ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i<arr.length; i++) {
            if(!check[i]) {
                check[i] = true;
                ds.add(arr[i]);
                permute(arr, ans, ds, check);
                ds.remove(ds.size()-1);
                check[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] check = new boolean[arr.length];
        permute(arr, ans, new ArrayList<>(), check);
        for(List<Integer> l : ans) {
            for(int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
