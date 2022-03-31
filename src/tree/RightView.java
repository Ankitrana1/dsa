package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {

    private static void rightView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i<size; i++) {
                TreeNode temp = queue.poll();
                if(i == 0)
                    res.add(temp.data);
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
            }
        }
        for(Integer i : res)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        rightView(TreeUtil.getTree2());
        System.out.println();
        rightView(TreeUtil.getTree());
    }
}
