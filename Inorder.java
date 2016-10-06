/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Recursive Solution 
// O(n) time
// O(n) space - as stack frames for each of the left and right node of root for every subtrees

public class Inorder 
{   
    List<Integer> result = new ArrayList<Integer>(); 
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        if(root !=null)
        {
            helper(root);
        }
 
        return result;
    }
 
    public void helper(TreeNode p)
	{
        if(p.left!=null)
            helper(p.left);
 
        result.add(p.val);
 
        if(p.right!=null)
            helper(p.right);
    }
}