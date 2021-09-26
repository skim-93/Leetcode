class Solution {
    public int search(int[] nums, int target) {
        //int start, end 
        int start = 0;
        int end = nums.length -1;
        
        //while(start <= end)
        while(start <= end) {
            
            int mid = (start + end) /2 ;
            System.out.println(mid);
            
            if(nums[mid] == target) {
                return mid;
            } 
            
            if(nums[mid] >= nums[start]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            
        }
        
        //if mid == target => return mid
        
        //if start > target && mid > target => start = mid + 1
        
        //if target < mid && target > end => end = mid - 1;
        
        //not found return -1;
        
        return -1;
    }
}

//[ 4 5 1 2 3]

//[1,2,3,4,5]
