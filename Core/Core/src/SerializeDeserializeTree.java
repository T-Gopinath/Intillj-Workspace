/*
            ✅ Java Program — Serialize & Deserialize Binary Tree (Preorder)
            Here is a clean, interview-ready Java program to
            Serialize + Deserialize a Binary Tree using Preorder Traversal with
             Null markers (e.g., "1,2,null,null,3,4,null,null,5,null,null").

            This is the standard LeetCode / interview solution.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

    // ---------------- SERIALIZATION ----------------
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


// ---------------- DESERIALIZATION ----------------
public TreeNode deserialize(String data) {
    String[] values = data.split(",");
    Queue<String> queue = new LinkedList<>(Arrays.asList(values));
    return deserializeHelper(queue);
}

private TreeNode deserializeHelper(Queue<String> queue) {
    String val = queue.poll();

    if (val.equals("null")) {
        return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = deserializeHelper(queue);
    node.right = deserializeHelper(queue);
    return node;
}

// ---------------- TEST ----------------
public static void main(String[] args) {
    SerializeDeserializeTree codec = new SerializeDeserializeTree();

    // Building sample tree:
    //        1
    //      /   \
    //     2     3
    //          / \
    //         4   5
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    // Serialize
    String s = codec.serialize(root);
    System.out.println("Serialized: " + s);

    // Deserialize
    TreeNode node = codec.deserialize(s);
    System.out.println("Deserialization success: " + (node != null));
}
}