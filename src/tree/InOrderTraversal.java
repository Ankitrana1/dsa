package tree;

public class InOrderTraversal {

    private static void inOrderTraversal(TreeNode root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print( root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        inOrderTraversal(TreeUtil.getTree());
    }
}
