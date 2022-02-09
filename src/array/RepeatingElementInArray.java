package array;

public class RepeatingElementInArray {
    public static void main(String[] args) {
        int[] arr = {1,1,5,3,4};
        repeatingElementInArray(arr);
    }

    //Can only work with duplicate numbers having at most occurring two times in the array
    private static void repeatingElementInArray(int[] arr){
        for(int i : arr){
            int j = Math.abs(i)-1;
            if(arr[j] < 0){
                System.out.print( Math.abs(i) + " ");
            } else {
                arr[j] = -arr[j];
            }
        }
    }
}
