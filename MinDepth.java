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
    public int minDepth(TreeNode root) 
    {
        /*
		RECURSIVE SOLUTION - EASY
		
        if(root == null) 
            return 0;
        if(root.left ==null) 
            return 1+minDepth(root.right);
        if(root.right ==null) 
            return 1+minDepth(root.left);
        
        return 1+Math.min(minDepth(root.left),minDepth(root.right));    
		*/
		
		// ITERATIVE SOLUTION
		
        if(root == null)
        {
            return 0;
        }
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
 
        nodes.add(root);
        counts.add(1);
 
        while(!nodes.isEmpty())
		{
            TreeNode curr = nodes.remove();
            int count = counts.remove();
 
			// optimization - if found first leaf -> that's the minimum depth of the binary tree
            if(curr.left == null && curr.right == null)
			{
                return count;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }
        return 0;
    }
    
}