package tree;

public class DiameterofTree {
    //Longest path between any two nodes ( either including root or not)

    private static int diameter(TreeNode root, int max) {
        if(root == null) return 0;
        int leftMaxDiameter = diameter(root.left,max);
        int rightMaxDiameter = diameter(root.right, max);
        max = Math.max(max, leftMaxDiameter + rightMaxDiameter);
        return Math.max(leftMaxDiameter, rightMaxDiameter) + 1;
    }

    public static void main(String[] args) {
        System.out.println(diameter(TreeUtil.getTree(), 0));
    }
}
