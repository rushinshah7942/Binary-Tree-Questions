/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Iterative Solution
 
public class Solution 
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null)    
            return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
    
        while(!stack.isEmpty())
        {
            TreeNode n = stack.pop();
            result.add(n.val);
            
			// pushing right child first so left child can be processed prior. 
            if(n.right != null)
                stack.push(n.right);
            
            if(n.left != null)
                stack.push(n.left);
        }
        return result;
        
    }
    
}

/* Recursive Solution (Very easy)

	List<Integer> result = new ArrayList<Integer>();

	public List<Integer> preorderTraversal(TreeNode root) 
	{
		if(root == null) 
            return Collections.EMPTY_LIST;

        List<Integer> preOrder = new ArrayList<Integer>();

        preOrder.add(root.val);
        preOrder.addAll(preorderTraversal(root.left));
        preOrder.addAll(preorderTraversal(root.right));

        return preOrder;
	}
	

*/
