package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class Insertion {

    private static TreeNode insert(TreeNode root, int value) {

        TreeNode node = new TreeNode(value);
        TreeNode cur = root;
        while (true) {
            if(cur.data >= value) {
                if(cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            }
            else {
                if(cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = insert(TreeUtil.getBST(), 16);
        System.out.println(root.right.right.left.data);
        root = insert(TreeUtil.getBST(), 8);
        System.out.println(root.left.right.right.left.data);
    }
}
