class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        //Brute-Force Solution
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    int[] ans = new int[2];
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        //time Complexity = O(n^2);
        //Space Complexity = O(1);
        return null;
        */
        
        //Optimized Solution - use of Additional Space (Hash Map)
        
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        
        for(int num : nums) {
            int numDiff = target - num;
            if(map.containsKey(numDiff)) {
                int[] ans = new int[2];
                ans[0] = map.get(numDiff);
                ans[1] = counter;
                return ans;
            } else {
                map.put(num, counter);
            }
            counter++;
        }
        //time Complexity = O(n)
        //space Complexity = O(n)
        
        return null;
    }
}