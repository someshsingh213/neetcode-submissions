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

        int level = 1;
        Stack<Map<TreeNode,Integer>> stack = new Stack<>();
        Map<TreeNode,Integer> map = new HashMap<>();
        map.put(root, level);
        stack.push(map);

        while(!stack.isEmpty() && stack.peek() != null) {
            Map<TreeNode, Integer> topMost = stack.pop();
            TreeNode node = null;
            int levelOfNode = 0;
            for(TreeNode i : topMost.keySet()){
                node = i;
                levelOfNode = topMost.get(i);
            }
            if(node.right != null){
                level = Math.max(level, levelOfNode +1);
                        Map<TreeNode,Integer> map1 = new HashMap<>();
        map1.put(node.right, levelOfNode + 1);
        stack.push(map1);
            }
            if(node.left != null){
                level = Math.max(level, levelOfNode +1);
                                        Map<TreeNode,Integer> map1 = new HashMap<>();
        map1.put(node.left, levelOfNode + 1);
        stack.push(map1);
            }
        }

        return level;
    }
}
