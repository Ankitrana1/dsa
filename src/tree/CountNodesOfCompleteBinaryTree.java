package tree;

public class CountNodesOfCompleteBinaryTree {

    //Time Complexity : O(logN)
    private static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if(lh == rh)
            return ((2 << (lh-1)) - 1);
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int getLeftHeight(TreeNode node) {
        int count = 0;
        while(node != null){
            node = node.left;
            count++;
        }
        return count;
    }

    private static int getRightHeight(TreeNode node) {
        int count = 0;
        while(node != null){
            node = node.right;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNodes(TreeUtil.getCompleteBinaryTree()));
    }
}
