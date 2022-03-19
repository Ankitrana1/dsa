package tree;

public class MaxPathSum {
//find max path by adding the node values in the path
    private static int maxPath(TreeNode root, int[] max) {
        if(root == null) return 0;
        int leftMaxSum = maxPath(root.left,max);
        int rightMaxSum = maxPath(root.right, max);
        max[0] = Math.max(max[0], leftMaxSum + rightMaxSum + root.data);
        return root.data + Math.max(leftMaxSum, rightMaxSum);
    }

    public static void main(String[] args) {
        int[] max = new int[1]; //Integer is immutable in java, so can't be passed as reference
        max[0] = Integer.MIN_VALUE;
        maxPath(TreeUtil.getTree(), max);
        System.out.println(max[0]);
    }
}
