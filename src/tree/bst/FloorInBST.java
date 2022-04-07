package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

public class FloorInBST {

    private static int floor(TreeNode root, int key) {
        int floor = -1;
        while(root != null) {
            if(root.data == key){
                floor = root.data;
                return floor;
            } else if(root.data > key)
                root = root.left;
            else {
                floor = root.data;
                root = root.right;
            }
        }
        return  floor;
    }

    public static void main(String[] args) {
        System.out.println(floor(TreeUtil.getBST(), 8));
    }
}
