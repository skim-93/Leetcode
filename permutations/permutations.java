class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        //this to track, if we visited, certain index
        boolean[] visited = new boolean[nums.length];
        
        dfs(res, nums, new ArrayList(), visited);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) {
        //if currentsize reaches nums.length, that means ,we found the permutation successfully
        if(curr.size() == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }
        
        //for loop to go through each index, 
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == true) {
                continue;
            }
            
            curr.add(nums[i]);
            visited[i] = true;
            dfs(res, nums, curr, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
            
        }
        
    }
    
}