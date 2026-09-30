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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        for(int i = 0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                rootIndex = i;
            }
        }

        int [] leftPreOrder = new int [rootIndex];
        int [] rightPreOrder = new int [inorder.length - 1 - rootIndex];
        int [] leftInOrder = new int [rootIndex];
        int [] rightInOrder = new int [inorder.length - 1 - rootIndex];

        for(int i = 0; i<leftPreOrder.length; i++){
            leftPreOrder[i] = preorder[i+1];
            leftInOrder[i] = inorder[i];
        }

        for(int i = 0; i<rightPreOrder.length; i++){
            rightPreOrder[i] = preorder[rootIndex + 1 + i];
            rightInOrder[i] = inorder[rootIndex + i + 1];
        }

        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;

    }
}
