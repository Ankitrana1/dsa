package tree.bst;

import org.w3c.dom.Node;
import tree.TreeNode;
import tree.TreeUtil;

public class LargestBST {
    //Return the count of nodes forming the largest BST in given BT.

    private static class NodeMetadata {
        int min, max, size;
        NodeMetadata(int min, int max, int size) {
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    private static NodeMetadata getLargestBST(TreeNode root) {
        if(root == null)
            return new NodeMetadata(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        NodeMetadata left = getLargestBST(root.left);
        NodeMetadata right = getLargestBST(root.right);
        //Check whether left, right and node follow BST rules
        if(left.max < root.data && root.data < right.min) {
            return new NodeMetadata(Math.min(root.data, left.min),
                    Math.max(root.data, right.max), left.size + right.size + 1);
        }
        return new NodeMetadata(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

    public static void main(String[] args) {
        System.out.println(getLargestBST(TreeUtil.getBSTWith2BadNodes()).size);
        System.out.println(getLargestBST(TreeUtil.getBST()).size);
    }
}
