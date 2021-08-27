class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
    
        dfs(res, curr, 0, target, candidates, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> curr, int sum, int target, int[] candidates, int index) {
        if(sum == target) {
            if(!res.contains(curr)) {
                res.add(new ArrayList(curr));
            }
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(sum + candidates[i] > target) {
                return;
            }
            
            curr.add(candidates[i]);
            sum = sum + candidates[i];
            dfs(res, curr, sum, target, candidates, i);
            curr.remove(curr.size() - 1);
            sum = sum - candidates[i];
        }
    }
    
}