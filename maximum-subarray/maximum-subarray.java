class Solution {
    public int maxSubArray(int[] nums) {
        int counter = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > counter + nums[i]) {
                counter = nums[i];
                
            } else {
                counter += nums[i];
            }
            max = Math.max(counter, max);
        }
        return max;
    }
}