class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e16;

        while (left < right) {
            long mid = (left + right) / 2;

            if (canReduce(mountainHeight, workerTimes, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReduce(int height, int[] workerTimes, long time) {
        long total = 0;

        for (int w : workerTimes) {
            long x = (long)(Math.sqrt(2.0 * time / w + 0.25) - 0.5);
            total += x;
            if (total >= height) return true;
        }

        return total >= height;
    }
}