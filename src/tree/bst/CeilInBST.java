package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class CeilInBST {

    private static int ceil(TreeNode root, int key) {
        int ceil = -1;
        while(root != null) {
            if(root.data == key) {
                ceil = root.data;
                return ceil;
            } else if(root.data < key) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        System.out.println(ceil(TreeUtil.getBST(), 9));
    }
}
