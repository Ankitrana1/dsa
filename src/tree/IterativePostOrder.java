package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {

    private static List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            if(root.left != null)
                stack1.push(root.left);
            if(root.right != null)
                stack1.push(root.right);
            stack2.push(root);
        }
        while (!stack2.isEmpty())
            res.add(stack2.pop().data);
        return res;
    }

    public static void main(String[] args) {
        for(int i : iterativeTraversal(TreeUtil.getTree()))
            System.out.print(i + " ");
    }
}
