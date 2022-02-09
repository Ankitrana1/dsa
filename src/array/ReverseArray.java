package array;

import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter 'n' array values : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        reverseArray(arr);
        printArray(arr);
    }

    private static void reverseArray(int[] arr){
        int m = arr.length/2, temp = 0;
        for(int i=0; i<m; i++){
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        printArray(arr);
    }

    private static void printArray(int[] arr){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
