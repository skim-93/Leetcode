class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxCurrent = nums[0];
        for(int i=1; i<nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent+nums[i]);
            if(maxCurrent>maxSum) {
                maxSum = maxCurrent;
            }
        }
        return maxSum;
    }
}