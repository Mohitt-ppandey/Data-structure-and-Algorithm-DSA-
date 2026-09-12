class Solution {
    static int ans;
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        count(root);
        return ans;
    }
    public void count(TreeNode root) {
        if(root == null) return;
        int[] count = {0};
        int sum = findSum(root , count);
        if(root.val == (sum)/count[0]) ans++;
        count(root.left);
        count(root.right);
    }
    public int findSum(TreeNode root , int[] count) {
        if(root == null) return 0;
        count[0]++;
        return root.val + findSum(root.left , count) + findSum(root.right , count);
    }
}