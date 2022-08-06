package array;

public class LargestSubarraySum {
    //Kadane's Algorithm
    private static int subArraySum(int[] nums) {
        int curMax = 0, max= 0;
        for(int i : nums) {
            curMax += i;
            if(curMax < 0){
                curMax = 0;
            } else if(max < curMax) {
                max = curMax;
            }
        }
        return max;
    }

    //Kadane's don't work for only negative input array
    private static int subArraySumForNegatives(int[] nums) {
        int curMax = nums[0], max = nums[0];
        for(int i = 1; i<nums.length; i++) {
            curMax = Math.max(curMax, curMax + nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {1,-2,-6,7,-5,2,-1,5,-8,-3,4};
        int[] nums2 = {-5,-7,-1,-8,-3,-2};
        System.out.println("Maximum contiguous sub-array sum : " + subArraySum(nums));
        System.out.println("Maximum contiguous sub-array sum : " + subArraySumForNegatives(nums2));
    }
}
