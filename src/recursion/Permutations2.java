package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    /*
    Different way to print all permutations without the extra space to check whether it's picked or not.
    */

    private static void permute(int index, int[] arr, List<List<Integer>> ans) {
        if(index == arr.length){
            List<Integer> ds = new ArrayList<>();
            for(int i : arr)
                ds.add(i);
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<arr.length; i++) {
            swap(i, index, arr);
            permute(index+1, arr, ans);
            swap(i, index, arr);
        }
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        List<List<Integer>> ans = new ArrayList<>();
        permute(0, arr, ans);
        for(List<Integer> l : ans) {
            for(int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
