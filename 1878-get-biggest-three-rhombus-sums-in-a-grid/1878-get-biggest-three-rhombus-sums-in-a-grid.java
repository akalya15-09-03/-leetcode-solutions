class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxSize = (Math.min(m, n) - 1) / 2;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Every single cell is a rhombus of size 0
                set.add(grid[i][j]);
                
                for (int size = 1; size <= maxSize; size++) {
                    // Check if a rhombus of this size fits in the grid
                    if (i + 2 * size < m && j - size >= 0 && j + size < n) {
                        set.add(calculateSum(grid, i, j, size));
                    } else {
                        break; // Larger sizes won't fit if this one doesn't
                    }
                }
            }
        }

        // Extract the largest three unique sums
        int count = Math.min(set.size(), 3);
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = set.pollLast();
        }
        return res;
    }

    private int calculateSum(int[][] grid, int r, int c, int s) {
        int sum = 0;
        // Traverse 4 sides of the rhombus
        for (int i = 0; i < s; i++) {
            sum += grid[r + i][c - i];             // Top to Left
            sum += grid[r + s + i][c - s + i];     // Left to Bottom
            sum += grid[r + 2 * s - i][c + i];     // Bottom to Right
            sum += grid[r + s - i][c + s - i];     // Right to Top
        }
        return sum;
    }
}