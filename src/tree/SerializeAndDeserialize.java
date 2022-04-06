package tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {

    private static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("");
        if(root == null) return res.toString();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                res.append("null ");
                continue;
            }
            res.append(node.data).append(" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return res.toString();
    }

    private static TreeNode deserialize(String s) {
        if(s.equals("")) return null;
        String[] values = s.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i = 1; i<values.length; i++) {
            TreeNode parent = q.poll();
            if(!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if(!values[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String s = serialize(TreeUtil.getTree2());
        System.out.println("Serialize Tree: " + s);
        TreeNode root = deserialize(s);
        System.out.println("Preorder traversal for original tree");
        preOrderTraversal(TreeUtil.getTree2());
        System.out.println("\nPreorder Traversal after deserializing the tree");
        preOrderTraversal(root);
    }

    private static void preOrderTraversal(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
