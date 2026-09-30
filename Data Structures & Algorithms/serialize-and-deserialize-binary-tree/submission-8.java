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

public class Codec {

    // Encodes a tree to a single string.
    List<String> levelOrder;
    public String serialize(TreeNode root) {
        levelOrder = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null){
                levelOrder.add("N");
            } else {
                levelOrder.add("" + node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }

        String res = "";
        for(int i = 0; i<levelOrder.size() - 1; i++) {
            res = res + levelOrder.get(i) + ",";
        }

        res = res + levelOrder.get(levelOrder.size() - 1);    
        return res;
}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] encodedData = data.split(",");
        if(encodedData[0] == "" || encodedData[0].equals("N")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(encodedData[0]));
        TreeNode curr = root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(curr);
        int i = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            
            String leftItem = encodedData[i];
            if(leftItem.equals("N")){
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(leftItem));
                q.offer(node.left);
            }
            i++;
            String rightItem = encodedData[i];
            if(rightItem.equals("N")){
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(rightItem));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
