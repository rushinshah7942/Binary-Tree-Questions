// Iterative solution
// Concept: DFS (Depth First Search)

// O(n) time
// O(h) space - as using stack
public List<Integer> inorderTraversal(TreeNode root) 
{	
    List<Integer> result = new ArrayList<Integer>(); 
	if(root==null) 
        return result;
    
	Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
 
    while(!stack.isEmpty()){
        TreeNode top = stack.peek();		
		// Find left child first it exists
        if(top.left!=null){
            stack.push(top.left);
            top.left=null;
			// as we won't be accessing it again
        }else{
			// add node value 
            result.add(top.val);
            stack.pop();
            if(top.right!=null){
                stack.push(top.right);
            }
        }
    }
    return result;
}

// Without making left as null
public List<Integer> inorderTraversal(TreeNode root){
	List<Integer> result = new ArrayList<Integer>(); 
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode node = root;
	
	while(true){
		if(node != null){
			stack.push(node);
			node = node.left;
		}
		else{
			if(stack.isEmpty()){
				break;
			}
			node = stack.pop();
			
			node = node.right;
		}
	}
}	
 

// Morris Traversal 
// O(n) time
// O(1) SPACE - using concept of back-edge from right most predecessor to root (current node)

	public void inorder(Node root) 
	{
        Node current = root;
        while(current != null) 
		{
            //left is null then print the node and go to right
            if (current.left == null) 
			{
                System.out.print(current.data + " ");
                current = current.right;
            }
            else 
			{
                //find the predecessor.
                Node predecessor = current.left;
                //To find predecessor keep going right till right node is not null or right node is not current.
                while(predecessor.right != current && predecessor.right != null)
				{
                    predecessor = predecessor.right;
                }
                //if right node is null then go left after establishing link from predecessor to current.
                if(predecessor.right == null)
				{
                    predecessor.right = current;
                    current = current.left;
                }
				else
				{ 
					//left is already visit. Go rigth after visiting current.
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    } 