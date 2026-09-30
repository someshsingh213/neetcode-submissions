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
    List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        return list.get(k - 1);
    }

    void dfs(TreeNode node) {
        if(node == null){
            return;
        }
        if(node.left!=null){
            dfs(node.left);
        }
        list.add(node.val);
        if(node.right!=null){
            dfs(node.right);
        }
    }
}
