package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {

    private static int maxWidth(TreeNode root) {
        int width = 0;
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().index;
            int first = 0, last = 0;
            for(int i =0; i<size; i++) {
                int cur = queue.peek().index - min;
                TreeNode temp = queue.poll().node;
                if(i == 0) first = cur;
                if(i == size - 1) last = cur;
                if(temp.left != null)
                    queue.offer(new Pair(temp.left, 2*cur + 1));
                if(temp.right != null)
                    queue.offer(new Pair(temp.right, 2*cur + 2));
            }
            width = Math.max(width, last - first + 1);
        }
        return width;
    }

    public static void main(String[] args) {
        System.out.println(maxWidth(TreeUtil.getTree()));
        System.out.println(maxWidth(TreeUtil.getTree2()));
        System.out.println(maxWidth(TreeUtil.getTree3()));
    }
}

class Pair {
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
        this.index = index;
        this.node = node;
    }
}