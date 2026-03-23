import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // sort requirements by index
        Arrays.sort(requirements, (a, b) -> a[0] - b[0]);

        int maxInv = 400; // safe limit
        long[][] dp = new long[n + 1][maxInv + 1];

        dp[0][0] = 1;

        int reqIndex = 0;

        for (int len = 1; len <= n; len++) {

            for (int inv = 0; inv <= maxInv; inv++) {

                long val = 0;

                for (int k = 0; k <= Math.min(inv, len - 1); k++) {
                    val = (val + dp[len - 1][inv - k]) % MOD;
                }

                dp[len][inv] = val;
            }

            if (reqIndex < requirements.length &&
                requirements[reqIndex][0] == len - 1) {

                int requiredInv = requirements[reqIndex][1];

                for (int inv = 0; inv <= maxInv; inv++) {
                    if (inv != requiredInv) {
                        dp[len][inv] = 0;
                    }
                }

                reqIndex++;
            }
        }

        long ans = 0;
        for (int inv = 0; inv <= maxInv; inv++) {
            ans = (ans + dp[n][inv]) % MOD;
        }

        return (int) ans;
    }
}