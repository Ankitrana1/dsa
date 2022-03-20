package tree;

public class IdenticalTrees {

    private static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)
            return root1 == root2;
        return (root1.data == root2.data) && isIdentical(root1.left, root2.left)  && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        System.out.println(isIdentical(TreeUtil.getTree(), TreeUtil.getTree()));
    }
}
