package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class CountNodesInRange {

    private static Integer count = 0;

    private static void countNodes(TreeNode root, int l, int r) {
        if(root == null) return;
        if(l <= root.data && root.data <= r ) count = count+1;
        if(l <= root.data)
            countNodes(root.left, l, r);
        if(r >= root.data)
            countNodes(root.right, l, r);
    }

    public static void main(String[] args) {
        countNodes(TreeUtil.getBST(), 5, 16);
        System.out.println(count);
        count=0;
        countNodes(TreeUtil.getBST(), 2, 19);
        System.out.println(count);
        count=0;
        countNodes(TreeUtil.getBST(), 10, 10);
        System.out.println(count);
        count=0;
        countNodes(TreeUtil.getBST(), 6, 9);
        System.out.println(count);
    }
}
