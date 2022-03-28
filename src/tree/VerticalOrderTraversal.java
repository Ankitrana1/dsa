package tree;

import java.util.*;

public class VerticalOrderTraversal {

    private static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(root, 0, 0));

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            addItemToMap(item, map);
            if(item.node.left != null) {
                queue.offer(new Item(item.node.left, item.row + 1, item.col - 1));
            }
            if(item.node.right != null) {
                queue.offer(new Item(item.node.right, item.row + 1, item.col + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> m : map.values()) {
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> p : m.values()) {
                while (!p.isEmpty()) {
                    res.get(res.size() - 1).add(p.poll());
                }
            }
        }
        return res;
    }

    private static void addItemToMap(Item item, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        TreeNode temp = item.node;
        int x = item.row;
        int y = item.col;

        if(!map.containsKey(y)) {
            map.put(y, new TreeMap<>());
        }
        if(!map.get(y).containsKey(x)) {
            map.get(y).put(x, new PriorityQueue<>());
        }
        map.get(y).get(x).add(temp.data);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = verticalOrderTraversal(TreeUtil.getTree());
        for(List<Integer> l : res) {
            for (Integer i  :l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Item {
    TreeNode node;
    int row;
    int col;

    public Item(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
