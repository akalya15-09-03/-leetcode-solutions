class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // masks for the blocks
        final int LEFT  = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4); // seats 2-5  =>  30
        final int MID   = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6); // seats 4-7  => 120
        final int RIGHT = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8); // seats 6-9  => 480

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] rs : reservedSeats) {
            int r = rs[0], s = rs[1];
            // set bit for seat s (bit index s-1)
            map.put(r, map.getOrDefault(r, 0) | (1 << (s - 1)));
        }

        // rows with no reserved seats => 2 families each
        int ans = (n - map.size()) * 2;

        // process only rows that have reserved seats
        for (int mask : map.values()) {
            // if both left and right are free -> 2 families
            if ((mask & LEFT) == 0 && (mask & RIGHT) == 0) {
                ans += 2;
            } else {
                // otherwise if any one of left/mid/right free -> 1 family
                if ((mask & LEFT) == 0 || (mask & MID) == 0 || (mask & RIGHT) == 0) {
                    ans += 1;
                }
                // else 0 families in this row
            }
        }

        return ans;
    }
}