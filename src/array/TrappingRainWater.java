package array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {5,1,3,1,5};
        System.out.println("Water trapped found w/o optimisation : " + trappedWater(arr));
        System.out.println("Water trapped found with optimisation : " + trappedWaterOptimised(arr));
    }

    private static int trappedWater(int[] arr){
        int trappedWater = 0;
        for(int i = 1; i<arr.length; i++){
            int left = arr[i];
            for(int j = i-1; j>=0; j--){
                if(left < arr[j])
                    left = arr[j];
            }

            int right = arr[i];
            for (int k = i+1; k< arr.length; k++){
                if(right < arr[k])
                    right = arr[k];
            }

            trappedWater += Math.min(left, right) - arr[i];
        }
        return trappedWater;
    }

    private static int trappedWaterOptimised(int[] arr){
        int trappedWater = 0, currentLeft = Integer.MIN_VALUE, currentRight = Integer.MIN_VALUE;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for(int i = 0; i<arr.length; i++) {
            if(Math.max(currentLeft, arr[i])  > currentLeft){
                currentLeft = arr[i];
            }
            left[i] = currentLeft;
        }
        for(int j = arr.length - 1; j>=0; j--){
            if(Math.max(currentRight, arr[j])  > currentRight) {
                currentRight = arr[j];
            }
            right[j] = currentRight;
        }

        for (int k = 0; k< arr.length; k++){
            trappedWater += Math.min(left[k], right[k]) - arr[k];
        }
        return trappedWater;
    }
}
