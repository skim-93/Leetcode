class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates, target, res, new ArrayList(), 0, 0);
        return res;
    }    
    
    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> current, int sum,int index) {
        if(sum == target) {
            if(!res.contains(current)) {
                res.add(new ArrayList(current));
            }
            return;
        }
        

        
        for(int i = index; i < candidates.length; i++) {
            if(sum + candidates[i] > target) {
                return;
            }
            sum += candidates[i];
            
            current.add(candidates[i]);
            dfs(candidates, target , res, current, sum, i);
            current.remove(current.size() - 1);
            sum -= candidates[i];
        }
    }
    
}