/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root == null || root == p || root == q) 
            return root;
            
        TreeNode result = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            if(p.val < node.val && q.val < node.val)
            {
                stack.push(node.left); 
                result =  node.left;
            }
            else if(p.val > node.val && q.val > node.val)
            {
                stack.push(node.right);
                result = node.right;
            }
            else
            {
                break;
            }
        }
        return result;
    }
}

// Recursion

//Time complexity O(height of tree)
//Space complexity O(height of tree)
 
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if(root.val > Math.max(p.val,q.val)){
		lowestCommonAncestor(root.left,p,q);
	}
	else if(root.val < Math.min(p.val,q.val)){
		lowestCommonAncestor(root.right,p,q);
	}
	else
		return root;
}