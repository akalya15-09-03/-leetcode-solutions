class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];
        int[][] ans = new int[m][n];
        for (int k = 0; k < original.length; k++) {
            ans[k / n][k % n] = original[k];
        }
        return ans;
    }
}