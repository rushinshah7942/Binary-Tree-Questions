/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    /*
    The basic idea is here:
    -----------------------
    Say we have 2 arrays, PRE and IN.
    Preorder traversing implies that PRE[0] is the root node.
    Then, we can find this PRE[0] in IN, say it's IN[5].
    Now, we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
    Recursively doing this on subarrays, we can build a tree out of it
    */
	public TreeNode buildTree(int[] preorder, int[] inorder) 
	{
		int preStart = 0;
		int preEnd = preorder.length-1;
		int inStart = 0;
		int inEnd = inorder.length-1;
 
		return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
	}
 
	public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd)
	{
		if(preStart>preEnd||inStart>inEnd)
		{
			return null;
		}
 
		int val = preorder[preStart];
		TreeNode root = new TreeNode(val);
 
		//find parent element index from inorder
		int k=0;
		for(int i=0; i<inorder.length; i++)
		{
			if(val == inorder[i])
			{
				k=i;
				break;
			}
		}
 
		root.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
		root.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
 
		return root;
	}
}