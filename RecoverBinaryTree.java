/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/

// O(n) time and O(n) space 
// In-Order solution
// Basic idea is to visit the tree with in-order traversal and search for two swapped nodes. Then swap them back.

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
    public void recoverTree(TreeNode root) 
    {
        //use inorder traversal to detect incorrect node
        inOrder(root);
 
        int temp = first.val;
        first.val = second.val;
        second.val = temp;  
    }
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void inOrder(TreeNode root)
    {
        if(root == null) 
            return;
        //search left tree
        inOrder(root.left);
 
		if(prev != null && prev.val >= root.val)
        {
            //incorrect smaller node is always found as prev node
            if(first == null) 
                first = prev;
            //incorrect larger node is always found as current(root) node
            second = root;
        }
        
		//update prev node
        prev = root;
        //search right tree
        inOrder(root.right);
    }
}

// O(1) space using Morris-traversal
// O(n) time complexity

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
   public void recoverTree(TreeNode root) 
   {
	
    TreeNode first = null;
    TreeNode second = null;    
    TreeNode prev = null; 

    TreeNode predecessor = null; //rightmost node in left tree
    TreeNode current = root;
    
    while(current != null)
	{
        //for each node, we compare it with prev node as we did in in-order-traversal
        if(prev != null && current.val <= prev.val)
		{
            if(first == null) 
				first = prev;
            
			second = current;
        }
        
		// Below code consists wholly of Morris traversal logic
        if(current.left != null)
		{
            //got left tree, then let's locate its rightmost node in left tree
            predecessor = current.left;
            //we may have visited the left tree before, and connect the rightmost node with current node (root node)
            while(predecessor.right != null && predecessor.right != current)
			{
                predecessor = predecessor.right;
            }
            
            if(predecessor.right == current)
			{
                //if this left tree has been visited before, then we are done with it
                //cut the connection with currNode and start visit current's right tree
                predecessor.right = null;
                prev = current;
                current = current.right;
            }
			else
			{
                //if this left tree has not been visited before, then we create a back edge from rightmost node
                // to current node, so we can return to the start point after done the left tree
                predecessor.right = current;
                current = current.left;
            }
            
        }
		else
		{
            //no left tree, then just visit its right tree
            prev = current;
            current = current.right;
        }
    }
    
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
 }
}