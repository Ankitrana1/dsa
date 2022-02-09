package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    private static void printSubsequence(int index, List<Integer> temp, int[] arr, int size) {
        if(index >= size) {
            print(temp);
            return;
        }
        temp.add(arr[index]);
        printSubsequence(index+1, temp, arr, size);
        temp.remove(temp.size()-1);
        printSubsequence(index+1, temp, arr, size);
    }

    private static void print(List<Integer> arr) {
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5,2,4,3,1};
        printSubsequence(0, new ArrayList<>(), arr, arr.length);
    }
}
