class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        final int LEFT  = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4); 
        final int MID   = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6); 
        final int RIGHT = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8); 
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] rs : reservedSeats) {
            int r = rs[0], s = rs[1];
            map.put(r, map.getOrDefault(r, 0) | (1 << (s - 1)));
        }
       int ans = (n - map.size()) * 2;
       for (int mask : map.values()) {
            if ((mask & LEFT) == 0 && (mask & RIGHT) == 0) {
                ans += 2;
            } else {
                if ((mask & LEFT) == 0 || (mask & MID) == 0 || (mask & RIGHT) == 0) {
                    ans += 1;
                }
            }
        }

        return ans;
    }
}