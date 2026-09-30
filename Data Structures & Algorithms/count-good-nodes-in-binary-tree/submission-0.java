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
    int sum;
    public int goodNodes(TreeNode root) {
        sum = 0;
        dfs(root, Integer.MIN_VALUE);
        return sum;
    }

    void dfs(TreeNode root, int max) {
        if(root == null){
            return;
        }
        if(root.val >= max){
            sum++;
            max = Math.max(max, root.val);
        } 
        dfs(root.left, max);
        dfs(root.right, max);
        
    }
}
