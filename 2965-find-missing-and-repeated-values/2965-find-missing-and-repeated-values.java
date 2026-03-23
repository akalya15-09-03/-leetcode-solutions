class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;

        int[] freq = new int[size + 1];

        // count frequencies
        for (int[] row : grid) {
            for (int num : row) {
                freq[num]++;
            }
        }

        int missing = 0, repeated = 0;

        for (int i = 1; i <= size; i++) {
            if (freq[i] == 0) missing = i;
            if (freq[i] == 2) repeated = i;
        }

        return new int[]{repeated, missing};
    }
}