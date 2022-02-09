package recursion;

public class NaturalNumberSum {

    //Functional way
    public static int recurSum(int n)
    {
        if (n <= 1)
            return n;
        return n + recurSum(n - 1);
    }

    //Parameterize way
    public static void sum(int n,  int sum) {
        if(n < 1) {
            System.out.println(sum);
            return;
        }
        sum(n-1, n+sum);
    }

    // Driver code
    public static void main(String args[])
    {
        int n = 5;
        System.out.println(recurSum(n));
        sum(n, 0);
    }
}
