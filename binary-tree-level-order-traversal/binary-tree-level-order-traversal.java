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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        
        
        while(!que.isEmpty()) {
            int i = que.size();
            List<Integer> levNum = new ArrayList<Integer>();
            
            while(i > 0) {
                TreeNode current = que.poll();
                if(current != null) {
                    levNum.add(current.val);
                    que.offer(current.left);
                    que.offer(current.right);
                }
                
                i--;
            }
            if(!levNum.isEmpty()) {
                ans.add(levNum);
            }
            
        }
        
        
        
        
        return ans;
    }
}