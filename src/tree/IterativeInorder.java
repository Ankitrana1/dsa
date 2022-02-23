package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {

    private static List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty()) break;
                node = stack.pop();
                res.add(node.data);
                node = node.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i : iterativeTraversal(TreeUtil.getTree()))
            System.out.print(i + " ");
    }
}
