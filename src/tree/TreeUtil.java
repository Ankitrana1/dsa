package tree;

public class TreeUtil {

    public static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        TreeNode leaf4 = new TreeNode(7);
        TreeNode l32 = new TreeNode(5);
        l32.left = leaf4;
        TreeNode leaf31 = new TreeNode(4);
        TreeNode leaf34 = new TreeNode(6);
        TreeNode l21 = new TreeNode(2);
        l21.left = leaf31;
        l21.right = l32;
        TreeNode l22 = new TreeNode(3);
        l22.right = leaf34;
        root.left = l21;
        root.right = l22;
        return root;
        /*
                     1
                  2     3
                4   5     6
                   7
         */
    }
}

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}