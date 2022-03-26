package tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    private static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        if(!isLeaf(root))
            res.add(root.data);
        addLeftBoundary(root, res);
        addLeafNodes(root, res);
        addRightBoundary(root, res);
        return res;
    }

    private static void addLeftBoundary(TreeNode node, List<Integer> res) {
        TreeNode cur = node.left;
        while(cur != null){
            if(!isLeaf(cur))
                res.add(cur.data);
            if(cur.left != null)
                cur = cur.left;
            else
                cur = cur.right;
        }
    }

    private static void addLeafNodes(TreeNode node, List<Integer> res) {
        if(isLeaf(node)) {
            res.add(node.data);
            return;
        }
        if(node.left != null)
            addLeafNodes(node.left, res);
        if(node.right != null)
            addLeafNodes(node.right, res);
    }

    private static void addRightBoundary(TreeNode node, List<Integer> res) {
        List<Integer> temp = new ArrayList<>();
        TreeNode cur = node.right;
        while (cur != null) {
            if(!isLeaf(cur))
                temp.add(cur.data);
            if(cur.right != null)
                cur = cur.right;
            else
                cur = cur.left;
        }
        for(int i = temp.size() -1; i>=0; i--) {
            res.add(temp.get(i));
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        List<Integer> traversal = boundaryTraversal(TreeUtil.getTree());
        for(Integer i : traversal) {
            System.out.print(i + " ");
        }
    }
}
