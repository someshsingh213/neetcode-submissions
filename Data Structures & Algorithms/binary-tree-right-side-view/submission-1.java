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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> response = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //queue: 4, 5, 
        //response: 1, 3, 7
        while(!queue.isEmpty()){
            int size = queue.size(); //4
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll(); //3
                if(i == size-1){
                    response.add(node.val); 
                }
                if(node.left!=null){
                    queue.add(node.left); 
                    }
                if(node.right!=null){
                    queue.add(node.right); 
                    }
            }
        }
        return response;
    }
}
