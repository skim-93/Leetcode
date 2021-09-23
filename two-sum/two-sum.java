class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> set = new HashMap<>();
        int i = 0;
        int[] ans = new int[2];
        
        for(int num : nums) {
            int diff = target - num;
            if(set.containsKey(diff)) {
                ans[0] = set.get(diff);
                ans[1] = i;
                return ans;
            } else {
                set.put(num, i);
                i++;
            }
        }
        
        return new int[]{-1,-1};
    }
}