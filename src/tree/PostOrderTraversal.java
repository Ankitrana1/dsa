package tree;

public class PostOrderTraversal {

    private static void postOrderTraversal(TreeNode root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        postOrderTraversal(TreeUtil.getTree());
    }
}
