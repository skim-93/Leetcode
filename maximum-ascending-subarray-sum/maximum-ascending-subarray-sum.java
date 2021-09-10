class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int current = nums[0];
        
        if(nums.length <= 0) return nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                max = Math.max(max, current);
                current = nums[i];
            } else {
                current += nums[i];
            }
        }
        
        max = Math.max(max, current);
        
        return max;    
    }
}