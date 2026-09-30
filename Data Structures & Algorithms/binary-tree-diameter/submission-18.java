class Solution {
    private int best = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return best;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        best = Math.max(best, L + R);
        return 1 + Math.max(L, R);
    }
}
