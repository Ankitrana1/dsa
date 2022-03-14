package tree;

public class BalancedTree {

    private static int isBalanced(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = isBalanced(root.left);
        int rightHeight = isBalanced(root.right);

        if(leftHeight == -1 || rightHeight == -1)
            return -1;
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced(TreeUtil.getTree()));
    }
}
