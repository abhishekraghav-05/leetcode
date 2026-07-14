class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 200;

    public int subsequencePairCount(int[] nums) {
        int[][] dp = new int[MAX + 1][MAX + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            int[][] ndp = new int[MAX + 1][MAX + 1];

            // Skip current element
            for (int i = 0; i <= MAX; i++) {
                System.arraycopy(dp[i], 0, ndp[i], 0, MAX + 1);
            }

            for (int g1 = 0; g1 <= MAX; g1++) {
                for (int g2 = 0; g2 <= MAX; g2++) {
                    int cur = dp[g1][g2];
                    if (cur == 0) continue;

                    // Put into seq1
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    ndp[ng1][g2] = (ndp[ng1][g2] + cur) % MOD;

                    // Put into seq2
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    ndp[g1][ng2] = (ndp[g1][ng2] + cur) % MOD;
                }
            }

            dp = ndp;
        }

        long ans = 0;
        for (int g = 1; g <= MAX; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}