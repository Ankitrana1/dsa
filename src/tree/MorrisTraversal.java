package tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

    //Uses Threaded Binary Tree
    //Time Complexity : O(3n) ~ O(n)
    //Space Complexity: O(1)
    private static void morrisTraversal(TreeNode root) {
        if(root == null) return;
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left == null) {
                res.add(cur.data);
                cur = cur.right;
            } else {
                //find predecessor for cur in inorder
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    res.add(cur.data);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        for(Integer i : res) {
            System.out.print( i + " ");
        }
    }

    public static void main(String[] args) {
        morrisTraversal(TreeUtil.getCompleteBinaryTree());
    }
}
