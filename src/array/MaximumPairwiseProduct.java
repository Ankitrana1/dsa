package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProductFast(int[] numbers, int n) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, negMax1=Integer.MIN_VALUE, negMax2 = Integer.MIN_VALUE;

        if(n==2)
            return (long)Math.abs(numbers[0]) * Math.abs(numbers[1]);
        else if(n == 1)
            return numbers[0];
        else if(n == 0)
            return 0;

        for (int i = 0; i < n; ++i) {
            if(numbers[i] >= 0) {
                if(max1 <= numbers[i]){
                    max2 = max1;
                    max1 = numbers[i];
                } else if(numbers[i] > max2){
                    max2 = numbers[i];
                }
            } else {
                if(numbers[i] >= negMax1) {
                    negMax2 = negMax1;
                    negMax1 = numbers[i];
                } else  if(Math.abs(numbers[i]) > negMax2){
                    negMax2 = numbers[i];
                }
            }
        }
        if(negMax1 == Integer.MIN_VALUE || negMax2 == Integer.MIN_VALUE)
            return (long) max1*max2;
        if(max1 == Integer.MIN_VALUE || max2 == Integer.MIN_VALUE)
            return (long) Math.abs(negMax1) * Math.abs(negMax2);
        long product1 = (long) Math.abs(negMax1) * Math.abs(negMax2);
        long product2 = (long) max1*max2;
        if(product1 > product2)
            return product1;
        else
            return product2;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers, n));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
