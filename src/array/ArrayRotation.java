package array;

public class ArrayRotation {

    public static void main(String[] args) {
        String s1 = "s1100", s2 = "s7000";
        System.out.println(s1.compareTo(s2));
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter array size : ");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        System.out.println("Enter 'n' array values : ");
//        for(int i=0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        rotateArray(arr);
//        printArray(arr);
    }

    private static void rotateArray(int[] arr){

        printArray(arr);
    }

    private static void printArray(int[] arr){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
