package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesSum {
    /*
Print all subsequences whose sum is equal to given sum.
 */
    private static void printSubsequenceSum(int index, int s, List<Integer> temp, int[] arr, int sum, int size) {
        if(index == size) {
            if(s == sum) {
                for(int i : temp)
                    System.out.print(i + " ");
                System.out.println();
            }
            return;
        }
        s += arr[index];
        temp.add(arr[index]);
        printSubsequenceSum(index+1, s, temp, arr, sum, size);
        s-= arr[index];
        temp.remove(temp.size()-1);
        printSubsequenceSum(index+1, s, temp, arr, sum, size);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,5,4};
        printSubsequenceSum(0, 0, new ArrayList<>(), arr, 6, arr.length);
    }
}
