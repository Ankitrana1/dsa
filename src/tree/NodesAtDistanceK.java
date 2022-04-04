package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NodesAtDistanceK {

    private static void printNodesAtDistanceK(TreeNode root, int k, TreeNode target) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateParentMap(root, parentMap);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(target);
        visited.put(target, true);
        while(!q.isEmpty()) {
            int size = q.size();
            if(level == k) break;
            level++;
            for(int i = 0; i< size; i++) {
                TreeNode temp = q.poll();
                if(temp.left != null && visited.get(temp.left) == null) {
                    q.offer(temp.left);
                    visited.put(temp.left, true);
                }
                if(temp.right != null && visited.get(temp.right) == null) {
                    q.offer(temp.right);
                    visited.put(temp.right, true);
                }
                if(parentMap.get(temp) != null && visited.get(parentMap.get(temp)) == null) {
                    q.offer(parentMap.get(temp));
                    visited.put(parentMap.get(temp), true);
                }
            }
        }
        while(!q.isEmpty()) {
            System.out.println(q.poll().data);
        }
    }

    private static void populateParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap)  {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.left != null) {
                parentMap.put(temp.left, temp);
                q.offer(temp.left);
            }
            if(temp.right != null) {
                parentMap.put(temp.right, temp);
                q.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        printNodesAtDistanceK(TreeUtil.getTree(), 2, TreeUtil.getTree().left);
    }
}
