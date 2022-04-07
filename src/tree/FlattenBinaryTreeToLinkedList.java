package tree;

public class FlattenBinaryTreeToLinkedList {

    //Flatten the existing tree in linked list format similar to preorder traversal
    //And traversing the existing tree in right direction for every node should be same as preorder traversal.
    private static TreeNode prev = null;
    private static TreeNode flatten(TreeNode root) {
        if(root == null) return null;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
        return root;
    }

    public static void main(String[] args) {

        preOrderTraversal(TreeUtil.getCompleteBinaryTree());
        System.out.println();
        TreeNode res = flatten(TreeUtil.getCompleteBinaryTree());
        while(res != null){
            System.out.print( res.data + " ");
            res = res.right;
        }
    }

    private static void preOrderTraversal(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
