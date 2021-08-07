class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*
        //Brute-Force Solution
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        //Time Complexity: O(n^2)
        //Space Complexity: O(1)
        //Time limit Exceeded
        */
        
        //Optimized solution - Use of Hashset to store and use contains
        
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(set.contains(num)) { 
                return true;
            }
            set.add(num);
        }
        //TimeComplexity: O(n)
        //Space Complexity: O(n)
    
        return false;
    }
}
