/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(root, targetSum, ans, new ArrayList<Integer>());
        
        return ans;
    }
    
    public void dfs(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> current) {
        if(root == null) return;    
        
        sum -= root.val;
        
        if(sum == 0 && root.left == null && root.right == null) {
            List<Integer> alter = new ArrayList<>(current);
            alter.add(root.val);
            ans.add(alter);
            return;
        }
        
        
        current.add(root.val);
        
        
        dfs(root.left, sum, ans, current);
        dfs(root.right, sum, ans, current);
        
        current.remove(current.size() - 1);
        
        
        
    }
}