package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

import java.util.Stack;

public class Kth_SmallestElement {

    private static int kSmallestElement(TreeNode root, int k) {
        int count = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty()) break;
                node = stack.pop();
                count++;
                if(count == k) return node.data;
                node = node.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println((kSmallestElement(TreeUtil.getBST(), 6)));
        System.out.println((kSmallestElement(TreeUtil.getBST(), 7)));
    }
}
