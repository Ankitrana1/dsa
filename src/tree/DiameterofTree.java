package tree;

public class DiameterofTree {
    //Longest path between any two nodes ( either including root or not)

    private static int diameter(TreeNode root, int[] max) {
        if(root == null) return 0;
        int leftMaxDiameter = diameter(root.left,max);
        int rightMaxDiameter = diameter(root.right, max);
        max[0] = Math.max(max[0], leftMaxDiameter + rightMaxDiameter);
        return Math.max(leftMaxDiameter, rightMaxDiameter) + 1;
    }

    public static void main(String[] args) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        diameter(TreeUtil.getTree(), max);
        System.out.println(max[0]);
    }
}
