class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0) return false;
        int[][] pos = new int[n * n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pos[grid[i][j]][0] = i;
                pos[grid[i][j]][1] = j;
            }
        }
        for (int i = 0; i < n * n - 1; i++) {
            int x1 = pos[i][0], y1 = pos[i][1];
            int x2 = pos[i + 1][0], y2 = pos[i + 1][1];
            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);
            if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
                return false;
            }
        }
        return true;
    }
}