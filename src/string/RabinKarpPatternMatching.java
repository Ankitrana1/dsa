package string;

import java.util.Scanner;

public class RabinKarpPatternMatching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text and then pattern here :");
        String text = sc.next();
        String pattern = sc.next();
        if(text.isEmpty() && pattern.isEmpty() || (text.length() < pattern.length())){
            System.out.println("Enter valid strings!");
        }
        int pos = patternSearch(text, pattern);
        if(pos >= 0)
            System.out.println("Match found at" + pos);
        else
            System.out.println("Match not found!");
    }

    private static int patternSearch(String text, String pattern){
        if(text.length() == pattern.length()){
            for(int i=0; i<text.length(); i++){
                if(text.charAt(i) != pattern.charAt(i))
                    return -1;
            }
            return 0;
        } else {
            int patternHash = getHashForString(pattern);
            String subStr = text.substring(0, pattern.length());
            int subStrHash = getHashForString(subStr);
            for (int i = 0, j = pattern.length() - 1; j < text.length(); j++) {

            }
        }
        return -1;
    }

    private static int getHashForString(String s){
        int res=0;
        for(char c : s.toCharArray()){
            res += c - 97 + 1;
        }
        return res;
    }
}
