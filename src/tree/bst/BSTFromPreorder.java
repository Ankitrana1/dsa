package tree.bst;

import tree.TreeNode;

public class BSTFromPreorder {

    private static TreeNode construct(int[] preorder, int bound, int[] index) {
         if(index[0] == preorder.length || preorder[index[0]] > bound)
             return null;
         TreeNode node = new TreeNode(preorder[index[0]]);
         index[0] = index[0]+1;
         node.left = construct(preorder, node.data, index);
         node.right = construct(preorder, bound, index);
         return node;
    }

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        preOrderTraversal(construct(preorder, Integer.MAX_VALUE, new int[1]));
    }

    private static void preOrderTraversal(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
