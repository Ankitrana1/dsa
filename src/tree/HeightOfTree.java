package tree;

public class HeightOfTree {

    private  static int height(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(height(TreeUtil.getTree()));
    }
}
