package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

    private static void topView(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(root, 0 , 0));

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            TreeNode temp = item.node;
            if(!map.containsKey(item.col)) {
                map.put(item.col, temp.data);
            }
            if(temp.left != null) {
                queue.offer(new Item(temp.left, item.row + 1, item.col - 1));
            }
            if(temp.right != null) {
                queue.offer(new Item(temp.right, item.row + 1, item.col + 1));
            }
        }

        for(Integer i : map.values()) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        topView(TreeUtil.getTree());
    }
}
