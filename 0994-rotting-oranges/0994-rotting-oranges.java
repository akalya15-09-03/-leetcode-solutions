import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: count fresh & add rotten
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int time = 0;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean changed = false;

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                        changed = true;
                    }
                }
            }

            if (changed) time++;
        }

        return fresh == 0 ? time : -1;
    }
}