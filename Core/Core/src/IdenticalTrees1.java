/*
        ✅ Java Program — Check if Two Trees Are Identical

            Here is a clean and simple Java program to check if two binary trees are identical.

        Two trees are identical if:
        ✔ Structure is same
        ✔ Corresponding node values are same

 */

public class IdenticalTrees1 {

    public static boolean isIdentical(TreeNode p, TreeNode q) {
        // If both are null → identical
        if (p == null && q == null) return true;

        // If either is null → not identical
        if (p == null || q == null) return false;

        // Check value + left subtree + right subtree
        return (p.val == q.val) &&
                isIdentical(p.left, q.left) &&
                isIdentical(p.right, q.right);
    }

    public static void main(String[] args) {
        // Tree 1
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        // Tree 2
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);

        boolean result = isIdentical(a, b);
        System.out.println("Trees are identical: " + result);
    }
}
