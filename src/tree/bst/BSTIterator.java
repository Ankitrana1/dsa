package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

import java.util.Stack;

public class BSTIterator {
    private static Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        addElementToLeft(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode temp = stack.pop();
        addElementToLeft(temp.right);
        return temp.data;
    }

    private void addElementToLeft(TreeNode node) {
        while (node!= null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(TreeUtil.getBST());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
