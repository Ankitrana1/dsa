package tree.bst;

import tree.TreeNode;
import tree.TreeUtil;

import java.util.Stack;

public class TwoSum {

    private  static class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        boolean isReverse = true;

        public BSTIterator(TreeNode root, boolean isReverse) {
            this.isReverse = isReverse;
            pushElements(root);
        }

        public int next() {
            TreeNode temp = stack.pop();
            if(isReverse) {
                pushElements(temp.left);
            } else {
                pushElements(temp.right);
            }
            return temp.data;
        }

        private void pushElements(TreeNode node) {
            while (node!= null) {
                stack.push(node);
                if(isReverse)
                    node = node.right;
                else
                    node = node.left;
            }
        }
    }

    public static  boolean twoSum(TreeNode root, int target) {
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int start = l.next();
        int end = r.next();
        while (start != end) {
            if(start + end == target) {
                return true;
            }
            if(start + end > target)
                end = r.next();
            else
                start = l.next();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(TreeUtil.getBST(), 18));
        System.out.println(twoSum(TreeUtil.getBST(), 3));
    }
}
