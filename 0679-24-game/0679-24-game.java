class Solution {
    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = cards[i];
        }
        return solve(nums);
    }

    public boolean solve(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24) < 1e-6;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;

                double[] next = new double[nums.length - 1];
                int index = 0;

                for (int k = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        next[index++] = nums[k];
                    }
                }

                // Try all operations
                for (double val : compute(nums[i], nums[j])) {
                    next[index] = val;
                    if (solve(next)) return true;
                }
            }
        }
        return false;
    }

    public double[] compute(double a, double b) {
        return new double[]{
            a + b,
            a - b,
            b - a,
            a * b,
            b != 0 ? a / b : 0,
            a != 0 ? b / a : 0
        };
    }
}