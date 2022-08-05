package array;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargest {

    private static int findLargestUsingHeap(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int val : nums) {
            priorityQueue.offer(val);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    private static int findLargestUsingQuickSelect(int[] nums, int k) {
        //Need to shuffle the input array to randomise which helps to avoid the worst case O(N^2)
        shuffle(nums);
        k = nums.length - k;
        int low= 0;
        int high = nums.length-1;

        while(low <= high) {
            int index = partition(nums, low , high);
            if(index > k) {
                high = index - 1;
            } else if(index < k){
                low = index + 1;
            } else
                break;
        }
        return nums[k];
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for(int j = low; j< high; j++) {
            if(nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private static void shuffle(int[] nums) {
        Random random = new Random();
        for(int i = 1; i<nums.length; i++) {
            int r = random.nextInt(i+1);
            swap(nums, r, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {2,8,1,9,6,3,7,4};
        System.out.println(findLargestUsingHeap(nums, 4));

        System.out.println(findLargestUsingQuickSelect(nums, 4));
    }
}
