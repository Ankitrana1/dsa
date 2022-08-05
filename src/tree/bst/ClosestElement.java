package tree.bst;

import tree.TreeNode;

public class ClosestElement {

    private static int getClosestElement(TreeNode root, int target) {
        if(root == null) return -1;
        if(root.data == target) return root.data;
        return 0;
    }

    public static void main(String[] args) {

    }
}
