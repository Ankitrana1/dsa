package tree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumTimeToBurnTree {
    //Min Time to burn a tree from a target node

    private static void minTimeToBurnTree(TreeNode root, int target) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode tgtNode = populateParentMap(root, parentMap, target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int time = 0;
        q.offer(tgtNode);
        visited.put(tgtNode, true);

        while (!q.isEmpty()) {
            int size = q.size();
            int fl = 0;
            for(int i =0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left != null && visited.get(node.left) == null) {
                    fl = 1;
                    q.offer(node.left);
                    visited.put(node.left, true);
                }
                if(node.right != null && visited.get(node.right) == null) {
                    fl = 1;
                    q.offer(node.right);
                    visited.put(node.right, true);
                }
                if(parentMap.get(node) != null && visited.get(parentMap.get(node)) == null) {
                    fl = 1;
                    q.offer(parentMap.get(node));
                    visited.put(parentMap.get(node), true);
                }
            }
            if(fl == 1)
                time++;
        }
        System.out.println(time);
    }

    private static TreeNode populateParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap, int target)  {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode targetNode= null;
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.data == target)
                targetNode = temp;
            if(temp.left != null) {
                parentMap.put(temp.left, temp);
                q.offer(temp.left);
            }
            if(temp.right != null) {
                parentMap.put(temp.right, temp);
                q.offer(temp.right);
            }
        }
        return targetNode;
    }

    public static void main(String[] args) {
        minTimeToBurnTree(TreeUtil.getTree2(), 3);
    }
}
