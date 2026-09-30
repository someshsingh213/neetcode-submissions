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
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = root;
        getAncestor(root, p, q);
        return res;
    }

    private void getAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.val > root.val && q.val > root.val) {
            lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            lowestCommonAncestor(root.left, p, q);
        } else {
            res = root;
        }
    }
}
