/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
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
    // using inorder traversal 
    
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root)
    {
        if (root != null)
        {
            if (!isValidBST(root.left))
                return false;
 
            // allows only distinct values node
            if (prev != null && root.val <= prev.val)
                return false;
                
            prev = root;
            return isValidBST(root.right);
        }
        return true;
    }
    
    /*
    public boolean isValidBST(TreeNode root) 
    {
        return isValidBST(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    public boolean isValidBST(TreeNode p, double min, double max)
    {
        if(p == null)
            return true;
            
        if(p.val <= min || p.val >= max)
            return false;
        
        return isValidBST(p.left,min,p.val) && isValidBST(p.right,p.val,max)
    }
    */
    
}