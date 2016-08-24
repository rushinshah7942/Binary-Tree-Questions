// Iterative solution
// Concept: DFS (Depth First Search)

public List<Integer> inorderTraversal(TreeNode root) 
{	
    List<Integer> result = new ArrayList<Integer>();
 
	if(root==null) 
        return result;
    
	Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
 
    while(!stack.isEmpty())
	{
        TreeNode top = stack.peek();
		
		// Find left child first it exists
        if(top.left!=null)
		{
            stack.push(top.left);
            top.left=null;
			// as we won't be accessing it again
        }
		else
		{
			// add node value 
            result.add(top.val);
            stack.pop();
            if(top.right!=null)
			{
                stack.push(top.right);
            }
        }
    }
 
    return result;
}