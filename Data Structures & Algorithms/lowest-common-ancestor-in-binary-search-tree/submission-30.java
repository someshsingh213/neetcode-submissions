class Solution {
    static class Result {
        TreeNode best = null;
        int maxDepth = -1;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result res = new Result();
        traverseCandidates(root, p.val, q.val, 0, res);
        return res.best;
    }

    // Visit every node as candidate x
    private void traverseCandidates(TreeNode x, int pVal, int qVal, int depth, Result res) {
        if (x == null) return;

        if (isAncestorByValue(x, pVal) && isAncestorByValue(x, qVal)) {
            if (depth > res.maxDepth) {
                res.maxDepth = depth;
                res.best = x;
            }
        }

        traverseCandidates(x.left, pVal, qVal, depth + 1, res);
        traverseCandidates(x.right, pVal, qVal, depth + 1, res);
    }

    private boolean isAncestorByValue(TreeNode root, int targetVal) {
        if (root == null) return false;
        if (root.val == targetVal) return true;
        return isAncestorByValue(root.left, targetVal) || isAncestorByValue(root.right, targetVal);
    }
}
