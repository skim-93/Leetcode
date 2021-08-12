class Solution {
    public int maxSubArray(int[] nums) {
        int counter = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            counter = Math.max(nums[i], counter + nums[i]);
            if(counter > max) {
                max = counter;
            }
        }
        return max;
    }
}