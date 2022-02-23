package recursion;

public class Josephus {

    public static  int findTheWinner(int n, int k) {
        if(n == 1) return 1;
        else {
            int res = (findTheWinner(n-1, k)+k-1)%n;
            System.out.println(res);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2) + 1);
    }
}
