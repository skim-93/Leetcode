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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null){
            return new ArrayList<>();
        }
        
        boolean left = false;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            while(size > 0) {
                TreeNode current = q.poll();
                currentLevel.add(current.val);
                if(current.left != null) {
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }              
                size--;
            }
            
            if(level %2 == 0) {
                Collections.reverse(currentLevel);
            }

            level++;
            if(!currentLevel.isEmpty()) {
                res.add(currentLevel);
            }            
        }
        
        return res;
        
    }
}