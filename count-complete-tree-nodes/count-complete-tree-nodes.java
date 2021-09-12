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
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        int sum = 1;
        int n = countN(root, sum);
        return n;
    }
    
    public int countN(TreeNode root, int sum) {
        if(root.left == null) {
            return sum;
        }
        
        sum++;
        
        if(root.right == null) {
            return sum;
        }
        
        sum++;
        
        sum = countN(root.right, sum);
        sum = countN(root.left, sum);
        
        return sum;
    }
    
    /*
        // 1 -> RightNode (3) -> null -> (6) -> 
        // level = 0 -> 1 ->
        int level = 0;
        int levelFound = countLeftRight(root, level);
        int findNullCount = nullCount(root, level - 1);

        return ans;
    }
    
    public int countLeftRight(TreeNode root, int level) {
        if(root.left == null) {
            return level;
        }
        if(root.right == null) {
            return level;
        }
        level++; 
        
        return Math.max(countLeftRight(root.left, level), countLeftRight(root.right, level))
    }
    
    public int findNullCount(TreeNode root, int level) {
        int i = 0;        
        
    }
    */
}