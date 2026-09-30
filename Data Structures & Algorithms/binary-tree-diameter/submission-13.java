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
    public int diameterOfBinaryTree(TreeNode root) {
        //Base
        //recursion function
        //logic
        //return
        if(root == null){
            return 0;
        }

        int rightChildDiameter = diameterOfBinaryTree(root.right);
        int leftChildDiameter = diameterOfBinaryTree(root.left);
        int diameter = height(root.left) + height(root.right);

        int maxDiameter = Math.max(rightChildDiameter, Math.max(leftChildDiameter, diameter));

        return maxDiameter;


    }

    public int height(TreeNode root){
        

        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int heightOfNode = Math.max(leftHeight, rightHeight) + 1;

        return heightOfNode;
    }
}
