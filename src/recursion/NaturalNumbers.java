package recursion;

public class NaturalNumbers {
    //Print natural numbers N to 1
    private static void print(int n) {
        if(n == 0)
            return;
        System.out.print(n + " ");
        print(n -1);
    }
// Print 1 to N using backtracking
    private static void print2(int n) {
        if(n == 0)
            return;
        print2(n-1);
        System.out.print(n + " ");
    }

    //Print 1 to N
    private static void print3(int i, int n) {
        if(i > n)
            return;
        System.out.print(i + " ");
        print3(i+1, n);

    }

    public static void main(String[] args) {
        print(5);
        System.out.println();
        print2(5);
        System.out.println();
        print3(1,5);
    }s
}
