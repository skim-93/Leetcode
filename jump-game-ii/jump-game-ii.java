class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            dp[i] = i;    
        }
        //[0,1,2,3,4,5]
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j <= nums[i]; j++) {
                if(i + j >= nums.length) {
                    break;
                } else {
                    dp[i + j] = Math.min(dp[i+j], dp[i] + 1);
                }
            }
        }
        
        for(int i : dp) {
            System.out.println(i);
        }
        
        return dp[nums.length - 1];
    }
}