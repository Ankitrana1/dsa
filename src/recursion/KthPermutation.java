package recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    private static String solve(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i<n; i++) {
            fact = fact*i;
            nums.add(i);
        }
        nums.add(n);
        k = k-1;
        String res = "";
        while (true) {
            res = res + nums.get(k/fact);
            nums.remove(k/fact);
            if(nums.size() == 0)
                break;
            k = k%fact;
            fact = fact/nums.size();
        }
        return res;
    }

    public static void main(String[] args) {
        String res = solve(4,17);
        System.out.println(res);
    }
}
