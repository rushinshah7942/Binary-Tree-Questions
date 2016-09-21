/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator 
{
	// Stack initially contains all left children of root
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) 
    {
        stack = new Stack<TreeNode>();
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return !stack.isEmpty();    
    }

    /** @return the next smallest number */
    public int next() 
    {
        TreeNode node = stack.pop();
		int result = node.val;
		if (node.right != null) 
		{
			node = node.right;
			while (node != null) 
			{
				// everytime we include left children to get lowest value in BST
				stack.push(node);
				node = node.left;
			}
		}
		return result;    
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */