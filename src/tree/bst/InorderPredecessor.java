package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class InorderPredecessor {

    private static TreeNode getPredecessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while (root != null) {
            if(p.data > root.data) {
                pre = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        TreeNode root= TreeUtil.getBST();
        System.out.println(getPredecessor(root, root.left.right.right).data);
        System.out.println(getPredecessor(root, root).data);
        System.out.println(getPredecessor(root, root.left.left.left));
        System.out.println(getPredecessor(root, root.right.left).data);
    }
}
