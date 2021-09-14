class Solution {
    public int missingNumber(int[] nums) {
        
        int sum = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += count - nums[i];
            count++;
        }
        
        sum += count;
        
        return sum;
    }
}

