package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class ValidBST {

    private static boolean isValid(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.data >= max || root.data <= min) return false;
        return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
    }

    public static void main(String[] args) {
        System.out.println(isValid(TreeUtil.getBST(), Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isValid(TreeUtil.getTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
