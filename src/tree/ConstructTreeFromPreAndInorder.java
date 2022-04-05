package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreAndInorder {

    private static void constructTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< inorder.length; i++)
            map.put(inorder[i], i);
        TreeNode root = build(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, map);
        preOrderTraversal(root);
    }

    private static TreeNode build(int[] inorder, int inStart, int inEnd,
                                  int[] preorder, int preStart, int preEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        int left = index - inStart;

        root.left = build(inorder, inStart, index-1, preorder, preStart+1, preStart+left, map);
        root.right = build(inorder, index+1, inEnd, preorder, preStart+left+1, preEnd, map);
        return root;
    }

    private static void preOrderTraversal(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] preorder = {10, 20, 40, 50, 30, 60};
        constructTree(preorder, inorder);
    }
}
