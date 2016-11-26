/*
Number of visible nodes in binary tree.

i.e. In a binary tree, if in the path from root to the node A, there is no node with greater value than A’s, this node A is visible. We need to count the number of visible nodes in a binary tree.
*/

public int countVisible(TreeNode root) {
    return helper(root, Integer.MIN_VALUE);
}

private int helper(TreeNode node, int max) {
    if (node == null) {
        return 0;
    }

    if (node.val >= max) {
        return 1 + helper(node.left, node.val) + helper(node.right, node.val);
    } else {
        return helper(node.left, max) + helper(node.right, max);
    }
}