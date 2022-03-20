package tree;

import java.util.*;

public class ZigZagTraversal {

    private static void zigzagTraversal(TreeNode root, List<List<Integer>> res) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rDir = true; //is right direction

        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] row = new Integer[size];
            for(int i = 0; i<size; i++) {
                TreeNode temp = queue.poll();
                int index = rDir ? i : size - 1- i;
                row[index] =  temp.data;
                if(temp.left != null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
            }
            rDir = !rDir;
            res.add(Arrays.asList(row));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagTraversal(TreeUtil.getTree2(), res);
        for(List<Integer> l : res) {
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
