package recursion;

public class ArrayReverse {
    private static void reverse(int[] arr, int cur, int size) {
        if(cur >= size/2) return;
        swap(arr, cur, size - cur -1);
        reverse(arr, ++cur, size);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        reverse(arr, 0, arr.length);

        for(int i : arr)
            System.out.print(i + " ");
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
