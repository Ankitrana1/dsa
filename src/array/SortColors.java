package array;

import java.util.Arrays;

public class SortColors {

    private static void sortUsingFrequency(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for(int i : nums) {
            if(i == 0)
                count0++;
            else if(i == 1)
                count1++;
        }
        int count2 = nums.length - count0 - count1;
        int i = 0;
        while(count0 > 0) {
            nums[i++] = 0;
            count0--;
        }
        while(count1 > 0) {
            nums[i++] = 1;
            count1--;
        }
        while(count2 > 0) {
            nums[i++] = 2;
            count2--;
        }
        System.out.println("nums = " + Arrays.toString(nums));
    }

    private static void sortSinglePass(int[] nums) {
        int zero = 0, one = 0, two = nums.length -1;
        while(one <= two) {
            switch (nums[one]) {
                case 0 :
                    swap(nums, one, zero);
                    one++; zero++;
                    break;
                case 1 :
                    one++;
                    break;
                case 2 :
                    swap(nums, one, two);
                    two--;
                    break;
            }
        }
        System.out.println("nums = " + Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,2,1,0,2,0,1};

        sortUsingFrequency(nums);
        sortSinglePass(nums);
    }
}
