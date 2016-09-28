/*

Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

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

//Recursive -DFS
public class Solution 
{
    public TreeNode invertTree(TreeNode root) 
    {
        if(root == null)
            return null;
            
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = invertTree(right);
        root.right = invertTree(left);
        
        return root;
    }
}

// Iterative
public class Solution 
{
    public TreeNode invertTree(TreeNode root) 
	{
        if (root == null) 
		{
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) 
		{
			// below 4 lines are important
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
			// order of insertion into stack does not matter
            if(node.left != null) 
			{
                stack.push(node.left);
            }
            if(node.right != null) 
			{
                stack.push(node.right);
            }
        }
        return root;
    }
}
