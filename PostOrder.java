// Modifies the Binary tree
public List<Integer> postorderTraversal(TreeNode root) 
{
    List<Integer> result = new ArrayList<Integer>();
 
    if(root==null) 
	{
        return res;
    }
 
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
 
    while(!stack.isEmpty()) 
	{
        TreeNode temp = stack.peek();
        if(temp.left==null && temp.right==null) 
		{
            TreeNode pop = stack.pop();
            result.add(pop.val);
        }
        else {
            if(temp.right!=null) 
			{
                stack.push(temp.right);
                temp.right = null;
            }
 
            if(temp.left!=null) 
			{
                stack.push(temp.left);
                temp.left = null;
            }
        }
    }
 
    return result;
}

// Without modifiying input binary tree
public List<Integer> postorderTraversal(TreeNode root) {
	TreeNode current = root;
    Stack<TreeNode> stack = new LinkedList<>();
	
	while(current != null || !stack.isEmpty()){
		if(current != null){
			stack.push(current);
			current = current.left;
		}else{
			Node temp = stack.peek().right;
			if (temp == null) {
				temp = stack.poll();
				System.out.print(temp.data + " ");
				while (!stack.isEmpty() && temp == stack.peek().right) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
				}
			} else {
				current = temp;
			}
		}
	}
}