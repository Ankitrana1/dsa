package tree;

import java.util.ArrayList;
import java.util.List;

public class FindPathToNode {

    private static boolean findPath(TreeNode root, List<Integer> res, int target) {
        if(root == null)
            return false;
        if(root.data == target) {
            res.add(target);
            return true;
        }
        res.add(root.data);
        if(findPath(root.left, res, target) || findPath(root.right, res, target)) {
            return true;
        }
        res.remove(res.size()-1);
        return false;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        if(findPath(TreeUtil.getTree(), res, 7)) {
            for (Integer i : res)
                System.out.print(i + " ");
        } else {
            System.out.println("\nNo path found from root to target 7");
        }
        if(findPath(TreeUtil.getTree(), res, 9)) {
            for (Integer i : res)
                System.out.print(i + " ");
        } else {
            System.out.println("\nNo path found from root to target 9");
        }
    }
}
