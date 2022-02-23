package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder {

    private static List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.data);
            if(root.right != null)
                stack.push(root.right);
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i : iterativeTraversal(TreeUtil.getTree()))
            System.out.print(i + " ");
    }
}
