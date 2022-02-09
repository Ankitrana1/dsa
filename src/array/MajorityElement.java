package array;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {5,6,8,5,5,9,1,5,5};
        int[] arr2 = {1,6,5,4,1,6,5,4};

        printMajority(arr);
        printMajority(arr2);
    }
    /*
    Could have done using hashmap by counting frequency and comparing each frequency against n/2.
    time: O(n), space: O(n)
     */

//Moore Voting Algorithm, time: O(n), space: O(1)
    private static void printMajority(int[] arr){
        int candidate = findCandidate(arr);
        if(isMajority(arr, candidate)){
            System.out.println("Majority Element : "+ candidate);
        } else{
            System.out.println("No majority element found!");
        }
    }

    private static int findCandidate(int[] arr){
        int majorityIndex = 0, count =1, majorityElement = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(majorityElement == arr[i]){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                majorityElement = arr[i];
                count =1;
                majorityIndex = i;
            }
        }
        return arr[majorityIndex];
    }

    private static boolean isMajority(int[] arr, int element){
        int count = 0;
        for(int ele : arr){
            if(ele == element)
                count++;
        }
        return count > arr.length/2;
    }
}
