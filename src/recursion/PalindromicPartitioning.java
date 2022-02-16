package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {

    private static void solve(int partition, String s, List<String> temp, List<List<String>> ans) {
        if(partition == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = partition; i<s.length(); i++) {
            if(isPalindrome(s, partition, i)) {
                temp.add(s.substring(partition, i+1));
                solve(i+1, s, temp, ans);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> ans = new ArrayList<>();

        solve(0, s, new ArrayList<>(), ans);
        for(List<String> l : ans) {
            for(String str : l)
                System.out.print(str + ", ");
            System.out.println();
        }

    }
}
