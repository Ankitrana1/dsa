package tree;

public class LowestCommonAncestor {

    private static TreeNode lca(TreeNode root, TreeNode source, TreeNode target) {
        if(root == null || root == source || root == target)
            return root;
        TreeNode left = lca(root.left, source, target);
        TreeNode right  = lca(root.right, source, target);

        if(left == null)
            return right;
        if (right == null)
            return left;
        // when both left and right are not null, return the value
        else
            return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree();
        System.out.println(lca(root, root.left.left, root.right.right).data);

        System.out.println(lca(root, root.left.left, root.left.right.left).data);
    }
}
