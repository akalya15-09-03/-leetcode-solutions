class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        if (m == 0) return nums;
        int n = nums[0].length;
        if (m * n != r * c) return nums;

        int[][] ans = new int[r][c];
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = nums[k / n][k % n];
                k++;
            }
        }
        return ans;
    }
}