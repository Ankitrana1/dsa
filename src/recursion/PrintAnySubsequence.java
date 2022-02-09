package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAnySubsequence {
    /*
Print any 1 subsequence whose sum is equal to given sum.
 */
    private static boolean printSubsequence(int index, int s, List<Integer> temp, int[] arr, int sum, int size) {
        if(index == size) {
            if(s == sum){
                for(int i : temp)
                    System.out.print(i + " ");
                return true;
            }
            return false;
        }
        s += arr[index];
        temp.add(arr[index]);
        if(printSubsequence(index+1, s, temp, arr, sum, size))
            return true;
        s -= arr[index];
        temp.remove(temp.size()- 1);
        if(printSubsequence(index+1, s, temp, arr, sum, size))
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,4,3,1};
        printSubsequence(0, 0, new ArrayList<>(), arr, 8, arr.length);
    }
}
