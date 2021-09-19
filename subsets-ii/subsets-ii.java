class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permute(0, nums, new ArrayList(), res);
        return res;      
    }
    
    public void permute(int pos, int[] nums, List<Integer> set, List<List<Integer>> res) {
        if(!res.contains(set)) {
            res.add(new ArrayList(set));
        }
        
        for(int i = pos; i < nums.length; i++) {
            set.add(new Integer(nums[i]));
            permute(i+1, nums, set, res);
            set.remove(new Integer(nums[i]));
        } 
    }
}