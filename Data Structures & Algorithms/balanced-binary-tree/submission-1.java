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

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }

        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        if(Math.abs(heightLeft - heightRight) > 1) {
            isBalanced = false;
        }

        return Math.max(heightLeft, heightRight) + 1;
    }
}
