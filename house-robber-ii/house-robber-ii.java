class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(i == 0) {
                dp1[i] = nums[0];
            } else if(i == 1) {
                dp1[i]= Math.max(nums[0], nums[1]);
            } else {
                dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
            }
        }
        
        for(int i = 1; i < nums.length; i++) {
            if(i == 1) {
                dp2[i] = nums[1];
            } else if(i == 2) {
                dp2[i]= Math.max(nums[1], nums[2]);
            } else {
                dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
            }
        }
        
        return Math.max(dp1[nums.length-2], dp2[nums.length-1]);
    }
}