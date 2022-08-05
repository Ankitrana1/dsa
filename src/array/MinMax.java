package array;

//Find Min and Max elements in minimum number of swaps

public class MinMax {

    public static Node bruteMethod(int[] arr, int n) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            if(min > arr[i]) {
                min = arr[i];
            } else if(max < arr[i]) {
                max = arr[i];
            }
        }
        Node node = new Node(min, max);
        return node;
    }

    public static Node minimumComparison(int[] arr, int n) {
        int i;
        Node pair = new Node();
        if(n > 1) {
            if(n % 2 == 0) {
                if(arr[0] < arr[1]) {
                    pair.min = arr[0];
                    pair.max = arr[1];
                } else {
                    pair.min = arr[1];
                    pair.max = arr[0];
                }
                i = 2;
            } else {
                pair.min = arr[0];
                pair.max = arr[0];
                i = 1;
            }
            while(i<n-1) {
                if(arr[i] > arr[i+1]) {
                    if(pair.min > arr[i+1]){
                        pair.min = arr[i+1];
                    } else if(pair.max < arr[i]) {
                        pair.max = arr[i];
                    }
                } else {
                    if(pair.min > arr[i]){
                        pair.min = arr[i];
                    } else if(pair.max < arr[i+1]) {
                        pair.max = arr[i+1];
                    }
                }
                i+=2;
            }

        } else {
            pair.min = arr[0];
            pair.max = arr[0];
        }
        return pair;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 1, -9, 2};
        Node node = bruteMethod(arr, 6);
        System.out.println("Max : " + node.max +  " and Min : "+ node.min);

        Node node1 = minimumComparison(arr, 6);
        System.out.println("Max : " + node1.max +  " and Min : "+ node1.min);
    }
}

class Node {
    int min;
    int max;

    public Node() {
    }

    public Node(int min, int max) {
        this.max = max;
        this.min = min;
    }
}
