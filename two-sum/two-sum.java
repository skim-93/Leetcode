class Solution {
    public int[] twoSum(int[] nums, int target) {
        // solve it with extra space to save the difference.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                int[] ans = new int[2];
                ans[0] = map.get(diff);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
            
            
        }
        
        
        return new int[]{-1,-1};
    
    }
}