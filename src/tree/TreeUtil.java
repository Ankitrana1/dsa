package tree;

import java.util.Objects;

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

    public static TreeNode getTree2() {
        TreeNode root = new TreeNode(1);
        TreeNode leaf4 = new TreeNode(7);
        TreeNode leaf42 = new TreeNode(8);
        TreeNode l32 = new TreeNode(5);
        l32.left = leaf4;
        l32.right = leaf42;
        TreeNode leaf31 = new TreeNode(4);
        TreeNode leaf34 = new TreeNode(9);
        TreeNode leaf33 = new TreeNode(6);
        TreeNode l21 = new TreeNode(2);
        l21.left = leaf31;
        l21.right = l32;
        TreeNode l22 = new TreeNode(3);
        l22.left = leaf33;
        l22.right = leaf34;
        root.left = l21;
        root.right = l22;
        return root;
        /*
                     1
                  2     3
                4   5|6    9
                  7   8
         */
    }

    public static TreeNode getTree3() {
        TreeNode root = new TreeNode(1);
        TreeNode leaf4 = new TreeNode(7);
        TreeNode leaf31 = new TreeNode(4);
        leaf31.left = leaf4;
        TreeNode leaf34 = new TreeNode(8);
        TreeNode leaf44 = new TreeNode(9);
        leaf34.right = leaf44;
        TreeNode l21 = new TreeNode(2);
        l21.left = leaf31;
        TreeNode l22 = new TreeNode(3);
        l22.right = leaf34;
        root.left = l21;
        root.right = l22;
        return root;
        /*
                     1
                  2     3
                4         8
              7             9
         */
    }

    public static TreeNode getCompleteBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode leaf4 = new TreeNode(7);
        TreeNode leaf42 = new TreeNode(8);
        TreeNode leaf43 = new TreeNode(8);
        TreeNode l32 = new TreeNode(5);
        l32.left = leaf4;
        l32.right = leaf42;
        TreeNode leaf31 = new TreeNode(4);
        TreeNode leaf41 = new TreeNode(6);
        leaf31.left = leaf41;
        leaf31.right = leaf43;
        TreeNode leaf34 = new TreeNode(9);
        TreeNode leaf33 = new TreeNode(6);
        TreeNode l21 = new TreeNode(2);
        l21.left = leaf31;
        l21.right = l32;
        TreeNode l22 = new TreeNode(3);
        l22.left = leaf33;
        l22.right = leaf34;
        root.left = l21;
        root.right = l22;
        return root;
        /*
                     1
                  2     3
                4   5|6    9
              6  8 7  8
         */
    }

    public static TreeNode getBST() {
        TreeNode root = new TreeNode(10);
        TreeNode leaf4 = new TreeNode(6);
        TreeNode leaf42 = new TreeNode(9);
        TreeNode leaf43 = new TreeNode(4);
        TreeNode l32 = new TreeNode(7);
        l32.left = leaf4;
        l32.right = leaf42;
        TreeNode leaf31 = new TreeNode(3);
        TreeNode leaf41 = new TreeNode(2);
        leaf31.left = leaf41;
        leaf31.right = leaf43;
        TreeNode leaf34 = new TreeNode(19);
        TreeNode leaf33 = new TreeNode(12);
        TreeNode l21 = new TreeNode(5);
        l21.left = leaf31;
        l21.right = l32;
        TreeNode l22 = new TreeNode(14);
        l22.left = leaf33;
        l22.right = leaf34;
        root.left = l21;
        root.right = l22;
        return root;
        /*
                     10
                  5      14
                3   7  12   19
               2 4 6 9
         */
    }

    public static TreeNode getBSTWith2BadNodes() {
        TreeNode root = new TreeNode(10);
        TreeNode leaf4 = new TreeNode(14);
        TreeNode leaf42 = new TreeNode(9);
        TreeNode leaf43 = new TreeNode(4);
        TreeNode l32 = new TreeNode(7);
        l32.left = leaf4;
        l32.right = leaf42;
        TreeNode leaf31 = new TreeNode(3);
        TreeNode leaf41 = new TreeNode(2);
        leaf31.left = leaf41;
        leaf31.right = leaf43;
        TreeNode leaf34 = new TreeNode(19);
        TreeNode leaf33 = new TreeNode(12);
        TreeNode l21 = new TreeNode(5);
        l21.left = leaf31;
        l21.right = l32;
        TreeNode l22 = new TreeNode(6);
        l22.left = leaf33;
        l22.right = leaf34;
        root.left = l21;
        root.right = l22;
        return root;
        /*
                     10
                  5      6
                3   7  12   19
               2 4 14 9
         */
    }
}

