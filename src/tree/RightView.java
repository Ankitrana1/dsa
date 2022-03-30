package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class RightView {

    private static void rightView(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            TreeNode temp = node.node;

            map.put(node.level, temp.data);

            if(temp.left != null) {
                queue.offer(new Node(temp.left, node.level + 1));
            }
            if(temp.right != null) {
                queue.offer(new Node(temp.right, node.level + 1));
            }
        }

        for(Integer i : map.values())
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        rightView(TreeUtil.getTree2());
        System.out.println();
        rightView(TreeUtil.getTree());
    }

    private static class Node {
        public TreeNode node;
        public int level;

        public Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
