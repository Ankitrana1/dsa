package tree;

public class PreOrderTraversal {

    private static void preOrderTraversal(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        preOrderTraversal(TreeUtil.getTree());
    }
}
