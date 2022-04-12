package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class LCA {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.data > p.data && root.data > q.data)
            return lowestCommonAncestor(root.left, p, q);
        if(root.data < p.data && root.data < q.data)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.getBST();
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right.right).data);
        System.out.println(lowestCommonAncestor(root, root.left.left.right, root.right.left).data);
    }
}
