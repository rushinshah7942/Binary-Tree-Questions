/*
If you notice carefully in the flattened tree, each node's right child points to the next node of a 'pre-order traversal'.
*/

public void flatten(TreeNode root) 
    {
        /*
         
        TreeNode result = new TreeNode(0);
        TreeNode temp = result;
        if(root == null)    
            return;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode n = stack.pop();
            
            temp.right = n;
            temp.left = null;
            temp = temp.right;
            
            if(n.right != null)
                stack.push(n.right);
            
            if(n.left != null)
                stack.push(n.left);
        }
        
        root = result.right;
        */
        
        // As soon as you get left make it right child and next is right node...bingo!!
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
 
        while(p != null || !stack.empty())
		{
 
            if(p.right != null)
			{
                stack.push(p.right);
            }
 
            if(p.left != null)
			{
                p.right = p.left;
                p.left = null;
            }
			else if(!stack.empty())
			{
				// if reached leaf, then check for immediate right and make it your right node
                TreeNode temp = stack.pop();
                p.right=temp;
            }
 
            p = p.right;
        }
    }