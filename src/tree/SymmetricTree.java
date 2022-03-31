package tree;

public class SymmetricTree {

    private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)
            return root1 == root2;
        if(root1.data != root2.data)
            return false;
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);

    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeUtil.getTree().left, TreeUtil.getTree().right));
    }
}
