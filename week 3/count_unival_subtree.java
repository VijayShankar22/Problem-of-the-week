/*
Problem of the Week – Count Unival Subtrees

Problem Description:
In many systems, especially in distributed trees or replicated data structures,
it's important to find substructures that are uniform.
A unival tree (short for universal value tree) is a subtree where all the nodes
have the same value.

You are given the root of a binary tree, and your task is to count the number
of unival subtrees present in the tree.

Note:
- A single node is trivially considered a unival subtree.

Input Format:
- You will be given the root of a binary tree.
- Each node contains:
    • An integer value
    • Left and right children
- For coding practice, you may build the tree manually or from helper functions.

Output Format:
- Print a single integer: the number of unival subtrees.

Constraints:
- Number of nodes ≤ 1000
- Node values can be any integer (positive or negative)

Example Tree:
        0
       / \
      1   0
         / \
        1   0
       / \
      1   1

Example Output:
5

Explanation:
The unival subtrees are:
1. The left leaf with value 1
2. The rightmost leaf with value 0
3. The two leaf nodes with value 1 (in left-right subtree)
4. The subtree rooted at the node with value 1 (with two 1 children)
Hence, total = 5 unival subtrees.

Approach Hint:
- Use post-order traversal:
    • Recursively check left and right subtrees
    • Determine if current node forms a unival subtree:
        - Left and right subtrees are unival
        - Node’s value matches children’s (if they exist)
- Maintain a counter to track valid unival subtrees.

Expected Time Complexity:
- O(N), where N is the number of nodes in the tree

*/

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
public class count_unival_subtree {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        isUnival(root, count);
        return count[0];
    }
    private boolean isUnival(TreeNode node, int[] count) {
        if (node == null) return true;

        boolean leftUnival = isUnival(node.left, count);
        boolean rightUnival = isUnival(node.right, count);

        if (!leftUnival || !rightUnival) return false;

        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;

        count[0]++;
        return true;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);

        count_unival_subtree solver = new count_unival_subtree();
        System.out.println("Count = " + solver.countUnivalSubtrees(root));
    }
}
