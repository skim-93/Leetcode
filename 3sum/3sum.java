class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        
        Set<Integer> set = new HashSet();
        //[-4,-1,-1,0,1,2]

        for(int i = 0; i < nums.length - 2; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                computeSum(i, nums, res);
            }
        }
        return res;
    }
    
    
    private void computeSum(int index, int[] nums, List<List<Integer>> res) {

        
        int target = -nums[index];
        int left = index + 1;
        int right = nums.length - 1;
        
        //index = 0; left = 1, right = 2 , target = 0
        //[-4,-1,-1,0,1,2]
        while(left < right) {
            List<Integer> current = new ArrayList();
            if(nums[left] + nums[right] == target) {
                current.add(nums[index]);
                current.add(nums[left]);
                current.add(nums[right]);
                res.add(current);
                while(nums[left + 1] == nums[left] && (left + 2) < nums.length) {
                    left++;
                }
                left++;
                
                while(nums[right - 1] == nums[right] && (right - 2) > 0) {
                    right--;
                }
                right--;
            }
            
            else if(nums[left] + nums[right] < target) {
                while(nums[left + 1] == nums[left] && (left + 2) < nums.length) {
                    left++;
                }
                left++;
            } else if(nums[left] + nums[right] > target) {
                while(nums[right - 1] == nums[right] && (right - 2) > 0) {
                    right--;
                }
                right--;
            }    
        }
        
    }
}