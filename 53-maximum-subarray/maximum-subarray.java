class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; 
        int currentSum = nums[0];

        // A single for loop scanning through the array
        for (int i = 1; i < nums.length; i++) {
            // Decide to either add to the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Keep track of the highest sum we've seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}