package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostAndInorder {

    private static void constructTree(int[] postorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< inorder.length; i++)
            map.put(inorder[i], i);
        TreeNode root = build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
        postOrderTraversal(root);
    }

    private static TreeNode build(int[] inorder, int inStart, int inEnd,
                                  int[] postorder, int pStart, int pEnd, Map<Integer, Integer> map) {
        if(pStart > pEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        int index = map.get(postorder[pEnd]);
        int left = index - inStart;

        root.left = build(inorder, inStart, index-1, postorder, pStart, pStart+left-1, map);
        root.right = build(inorder, index+1, inEnd, postorder, pStart+left, pEnd-1, map);
        return root;
    }

    private static void postOrderTraversal(TreeNode root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};
        constructTree(postorder, inorder);
    }
}
