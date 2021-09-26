class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        return dfs(nums, target, memo);
    }
    
    public int dfs(int[] nums, int target, Integer[] memo) {
        if(target == 0) return 1;
        if(target < 0) return 0;
        
        if(memo[target] != null) return memo[target];
        
        int total = 0;
        for(int i = 0; i < nums.length; i ++) {
            total += dfs(nums, target - nums[i], memo);
        }
        
        memo[target] = total;
        return total;
    }
    
    //m = target sum
    //n = nums.length
    
    //time comeplexity = O(n*m^2)
    //Space comeplxity = O(m^2)
    
}