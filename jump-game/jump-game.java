class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1 )return true;
        int furthest = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0 && i == furthest) return false;
            furthest = Math.max(furthest, i + nums[i]);
            if(furthest >= nums.length - 1) return true;
        }
    
    
        return false;
    
    }
}