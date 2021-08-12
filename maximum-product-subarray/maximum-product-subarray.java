class Solution {
    public int maxProduct(int[] nums) {
        
        int res = nums[0];
        
        for(int i : nums) {
            res = Math.max(res, i);
        }
        
        int curMin = 1;
        int curMax = 1;
        
        for(int n : nums) {
            if(n == 0) {
                curMin = 1;
                curMax = 1;
            } else {
                int temp = curMax * n;
                curMax = Math.max(n * curMax,Math.max( n * curMin, n));
                curMin = Math.min(temp,Math.min( n * curMin, n));
                res = Math.max(res, curMax);
            }
        }
        return res;
    }
}