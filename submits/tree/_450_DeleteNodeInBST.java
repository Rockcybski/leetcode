package tree;

/*
 * leetcode 450

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

 */
public class _450_DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			//find the min in right, set min to current node, then delete min in current node's right tree
			TreeNode minNodeInRight = findMin(root.right);
			root.val = minNodeInRight.val;
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}
	
	private TreeNode findMin(TreeNode root) {
		if(root == null) {
			return root;
		}
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode r3 = new TreeNode(3);
		TreeNode r6 = new TreeNode(6);
		root.left = r3;
		root.right = r6;
		TreeNode r2 = new TreeNode(2);
		TreeNode r4 = new TreeNode(4);
		r3.left = r2;
		r3.right = r4;
		TreeNode r7 = new TreeNode(7);
		r6.right = r7;
		System.out.println(new _450_DeleteNodeInBST().deleteNode(root, 3));
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
