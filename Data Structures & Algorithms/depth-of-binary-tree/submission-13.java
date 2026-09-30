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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if(root!=null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode leftMost = queue.poll();
                if(leftMost.left!=null){
                    queue.add(leftMost.left);
                }
                if(leftMost.right!=null){
                    queue.add(leftMost.right);
                }
            }
            level++;
        }
        return level;
    }
}
