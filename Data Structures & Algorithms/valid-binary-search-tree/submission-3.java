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
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValid;
    }

    void dfs(TreeNode node, int x, int y) {
        if(node == null){
            return;
        }

        if(node.val > x && node.val < y){
        } else {
            isValid = false;
        }

        //left
        dfs(node.left, x, Math.min(y, node.val));
        //right
        dfs(node.right, Math.max(x, node.val), y);
        
    }
}
