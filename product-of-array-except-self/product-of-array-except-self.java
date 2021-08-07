class Solution {
    public int[] productExceptSelf(int[] nums) {
        // there would be three cases for this problem
        //1. no Zeros in the array -> then we find the total multiple and divide it by itself
        //2. one Zeros in the array -> then we find total multiple, make all the non-zero to zero, and only zero would be equal to totalMultiple
        //3. more than 1 zeros in the arry -> this would make all the array to zero.
        
        int countZero = 0;
        int totalMultiple = 1;
        
        //in one foreach loop, we count how many zero there is, and find total Multiple except zero.
        for(int num : nums) {
            if(num == 0) {
                countZero++;
            } else {
                totalMultiple *= num;
            }
        }
        
        // this would be case 3
        if(countZero > 1) {
            for(int i = 0; i < nums.length; i++) {
                nums[i] = 0; 
            }
        } else if (countZero == 0) {
            //This would be case 1
            for(int i = 0; i < nums.length; i++) {
                nums[i] = totalMultiple/nums[i]; 
            }
        } else {
            //this would be case 2
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    nums[i] = totalMultiple;
                } else {
                    nums[i] = 0;
                }
            }
        }
        
        //Time Complexity: O(n) -> since we run it two times, to count zero and totalMultiple and to change array elements. 
        //Space Complexity: O(1) -> we only use countZero and totalMultiple variables
        
        return nums;
    }
}