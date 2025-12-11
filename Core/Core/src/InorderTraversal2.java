// Inorder traversal without recursion (stack)

import java.util.Stack;

public class InorderTraversal2 {

    static void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop and visit
            curr = stack.pop();
            System.out.print(curr.val + " ");

            // Go to right subtree
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        // Sample tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        inorder(root);  // Output: 1 3 2
    }

    //    4
    //   / \
    //  2   6
    //  / \ / \
    //  1  3 5  7

    /*Stack operations: Push 4, push 2, push 1
    Visit 1
    Visit 2
    Visit 3
    Visit 4
    Visit 5
    Visit 6
    Visit 7*/
}
