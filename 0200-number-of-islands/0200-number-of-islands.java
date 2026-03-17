class Solution {

    public void backtrack(char[][] grid, int row, int col) {
        // boundary check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // mark visited
        grid[row][col] = '0';

        // explore 4 directions
        backtrack(grid, row + 1, col);
        backtrack(grid, row - 1, col);
        backtrack(grid, row, col + 1);
        backtrack(grid, row, col - 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    backtrack(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}