package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class BSTSearch {

    private static TreeNode search(TreeNode root, int value) {
        while(root != null && root.data != value) {
            root = root.data > value ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(search(TreeUtil.getBST(), 9).data);
    }
}
