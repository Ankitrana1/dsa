package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class InorderSuccessor {

    private static TreeNode getSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if(p.data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        TreeNode root= TreeUtil.getBST();
        System.out.println(getSuccessor(root, root.left.right.right).data);
        System.out.println(getSuccessor(root, root.right.right));
        System.out.println(getSuccessor(root, root.left.right.left).data);
        System.out.println(getSuccessor(root, root.left).data);
    }
}
