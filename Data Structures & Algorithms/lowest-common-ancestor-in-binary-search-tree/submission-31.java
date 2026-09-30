class Solution {

    private TreeNode best = null;
    private int maxDepth = -1;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val, 0);
        return best;
    }

    private void dfs(TreeNode node, int pVal, int qVal, int depth) {
        if (node == null) return;

        if (isAncestor(node, pVal) && isAncestor(node, qVal)) {
            if (depth > maxDepth) {
                maxDepth = depth;
                best = node;
            }
        }

        dfs(node.left, pVal, qVal, depth + 1);
        dfs(node.right, pVal, qVal, depth + 1);
    }

    private boolean isAncestor(TreeNode root, int targetVal) {
        if (root == null) return false;
        if (root.val == targetVal) return true;
        return isAncestor(root.left, targetVal) || isAncestor(root.right, targetVal);
    }
}
