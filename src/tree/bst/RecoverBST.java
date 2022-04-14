package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class RecoverBST {
    //Recover BST by swapping two bad nodes which are not in position.

    private static TreeNode first;
    private static TreeNode middle;
    private static TreeNode last;
    private static TreeNode prev;

    private static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.data > root.data) {
            if(first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    private static TreeNode recoverBST(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if(first != null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
        return root;
    }

    private static void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root= TreeUtil.getBSTWith2BadNodes();
        inorderTraversal(root);
        System.out.println();
        inorderTraversal(recoverBST(root));
    }
}
