package recursion;

public class CountSubsequence {
    /*
    Count  all the subsequences whose sum is equal to the given sum.
     */
    private static int countSubsequences(int index, int s, int[] arr, int sum, int size) {
        if(index == size) {
            if(s == sum)
                return 1;
            return 0;
        }
        s += arr[index];
        int l = countSubsequences(index+1, s, arr, sum, size);
        s-= arr[index];
        int r = countSubsequences(index+1, s, arr, sum, size);
        return l+r;
    }
    public static void main(String[] args) {
        int[] arr = {3,8,4,1,5,2,6,7};
        System.out.println(countSubsequences(0, 0, arr, 7, arr.length));
    }
}
