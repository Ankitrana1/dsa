package recursion;

public class PalindromeCheck {
    private static boolean isPalindrome(String s, int i, int length){
        if(i >= length/2) return true;
        if(s.charAt(i) != s.charAt(length - i - 1)) return false;
        return isPalindrome(s, i+1, length);
    }

    public static void main(String[] args) {
        String s1 = "MADAM";
        String s2 = "ANKIT";

        System.out.println(s1 + " is palindrome? : " + isPalindrome(s1, 0, s1.length()));
        System.out.println(s2 + " is palindrome? : " + isPalindrome(s2, 0, s1.length()));
    }
}
