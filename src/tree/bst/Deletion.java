package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class Deletion {

    private static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key > root.data) return deleteNode(root.right, key);
        else if(key < root.data) return deleteNode(root.left, key);
        else {
            if(root.left == null) return root.right;
            else if( root.right == null) return root.left;
            root.data = inorderSuccessor(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    private static int inorderSuccessor(TreeNode root) {
        int min = root.data;
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.getBST();
        deleteNode(root, 14);
        preOrderTraversal(root);
    }

    private static void preOrderTraversal(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
