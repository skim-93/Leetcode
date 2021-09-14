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
    boolean output = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        dfs(root, targetSum, sum);
        
        return output;
        
    }
    
    public void dfs(TreeNode root, int targetSum, int sum) {
        if(root != null) {
            sum += root.val;
            
            if(root.left == null && root.right == null) {
                if(sum == targetSum) {
                    output = true;
                }
            }
            dfs(root.left, targetSum, sum);
            dfs(root.right, targetSum, sum);
        }        
    }
}