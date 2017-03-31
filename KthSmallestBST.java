/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.


Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

*/

// Find while doing inorder Traversal
// O(n) - DFS

public class Solution {
    int count = 0;
	int current = 0;

	public int kthSmallest(TreeNode root, int k) {
		inOrderTraversal(root,k);
		return current;
	}

	public void inOrderTraversal(TreeNode root, int k){
		if(count==k) 
			return;
		else{
			if(root.left!=null) 
				inOrderTraversal(root.left, k);
			
			if(count==k) 
				return; //break after already found kth smallest.
        
			count++;
			if(count==k){
				current = root.val;
				return;
			} 
			
			if(root.right!=null) 
				inOrderTraversal(root.right, k);
		}
	}
}


// if k is in left substree, time complexity would be O(size of left subtree)
// else, O(n)

// Optimization
// if there is no duplicate element then we can store BST node's value as key and number of nodes in its left-subtree as value and just use that value

public int kthSmallest(TreeNode root, int k) {
	int count = countNodes(root.left); // if we can keep track of elements in left subtree for each of the nodes, then O(height of tree)

	if (k <= count) {
		return kthSmallest(root.left, k);
	} 
	else if (k > count + 1) {
		return kthSmallest(root.right, k-1-count); // 1 is counted as current node
	}
	
	return root.val;
}
    
public int countNodes(TreeNode n) {
	if (n == null) 
		return 0;
	
	return 1 + countNodes(n.left) + countNodes(n.right);
}

/*
Reference: http://stackoverflow.com/questions/2329171/find-kth-smallest-element-in-a-binary-search-tree-in-optimum-way

In a BST, the left subtree of node T contains only elements smaller than the value stored in T. If k is smaller than the number of elements in the left subtree, the kth smallest element must belong to the left subtree. Otherwise, if k is larger, then the kth smallest element is in the right subtree.

We can augment the BST to have each node in it store the number of elements in its left subtree (assume that the left subtree of a given node includes that node). With this piece of information, it is simple to traverse the tree by repeatedly asking for the number of elements in the left subtree, to decide whether to do recurse into the left or right subtree.

Now, suppose we are at node T:

If k == num_elements(left subtree of T), then the answer we're looking for is the value in node T.
If k > num_elements(left subtree of T), then obviously we can ignore the left subtree, because those elements will also be smaller than the kth smallest. So, we reduce the problem to finding the k - num_elements(left subtree of T) smallest element of the right subtree.
If k < num_elements(left subtree of T), then the kth smallest is somewhere in the left subtree, so we reduce the problem to finding the kth smallest element in the left subtree.
Complexity analysis:

This takes O(depth of node) time, which is O(log n) in the worst case on a balanced BST, or O(log n) on average for a random BST.

A BST requires O(n) storage, and it takes another O(n) to store the information about the number of elements. All BST operations take O(depth of node) time, and it takes O(depth of node) extra time to maintain the "number of elements" information for insertion, deletion or rotation of nodes. Therefore, storing information about the number of elements in the left subtree keeps the space and time complexity of a BST.


*/