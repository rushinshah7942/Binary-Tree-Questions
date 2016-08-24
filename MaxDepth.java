public int maxDepth(TreeNode root) 
    {
        /*
        
        // recursive - 1 ms
        
        if(root == null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
    
        if(left > right)
            return left+1;
        else
            return right+1; */
            
        if(root == null)
            return 0;
            
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();

        nodes.add(root);
        counts.add(1);
        
        int count = 0;
        while(!nodes.isEmpty())
        {
            TreeNode curr = nodes.remove();
            count = counts.remove();
				
			// only difference with code of min depth is that here we don't return value if leaf value is found.
			// Instead we find maximum count and return when al nodes are visited
			
            if(curr.left != null)
            {
                nodes.add(curr.left);
                counts.add(count+1);
            }
            if(curr.right != null)
            {
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }
        return count;
    }