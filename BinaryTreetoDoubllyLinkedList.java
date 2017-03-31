/*
Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place).

The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
The order of nodes in List must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal must be head node of the Circular List.

*/

// Reference: http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/

// Node class represents a Node of a Tree
class Node
{
    int val;
    Node left,right;
 
    public Node(int val)
    {
        this.val = val;
        left = right = null;
    }
}

public Node bTreeToCList(Node root)
{
	if (root == null)
		return null;

	// Recursively convert left and right subtrees
	Node left = bTreeToCList(root.left);
	Node right = bTreeToCList(root.right);

	// Make a circular linked list of single node
	// (or root). To do so, make the right and
	// left pointers of this node point to itself
	root.left = root.right = root;

	// Step 1 (concatenate the left list with the list 
	//         with single node, i.e., current node)
	// Step 2 (concatenate the returned list with the
	//         right List)
	return concatenate(concatenate(left, root), right);
}

// e.g. inorder traversal 25 12 30  10(root)  36 15 

public Node concatenate(Node leftList,Node rightList)
{
	// If either of the list is empty, then
	// return the other list
	if (leftList == null)
		return rightList;
	if (rightList == null)
		return leftList;

	// Store the last Node of left List
	Node leftLast = leftList.left; // e.g. 25.left will be 30

	// Store the last Node of right List
	Node rightLast = rightList.left;

	// Connect the last node of Left List
	// with the first Node of the right List
	leftLast.right = rightList; // join 30 right to root (rightList)
	rightList.left = leftLast; // 

	// left of first node refers to
	// the last node in the list
	leftList.left = rightLast;

	// Right of last node refers to the first
	// node of the List
	rightLast.right = leftList;

	// Return the Head of the List
	return leftList;
}
/*

How to Concatenate two circular DLLs?
--------------------------------------
Get the last node of the left list. Retrieving the last node is an O(1) operation, since the prev pointer of the head points to the last node of the list.
Connect it with the first node of the right list
Get the last node of the second list
Connect it with the head of the list. 

*/