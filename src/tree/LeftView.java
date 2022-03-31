package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {

    private static void leftView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i<size; i++) {
                TreeNode temp = queue.poll();
                if(i == 0)
                    res.add(temp.data);
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        for(Integer i : res)
            System.out.print(i + " ");
    }

    //Better space complexity
    private static void recursiveLeftView(TreeNode root, List<Integer> res, int level) {
        if(root == null)
            return;
        if(level == res.size())
            res.add(root.data);
        recursiveLeftView(root.left, res, level + 1);
        recursiveLeftView(root.right, res, level + 1);
    }

    public static void main(String[] args) {
        leftView(TreeUtil.getTree());
        System.out.println();
        List<Integer> res = new ArrayList<>();
        recursiveLeftView(TreeUtil.getTree(), res, 0);
        for(Integer i : res)
            System.out.print(i + " ");
    }
}
