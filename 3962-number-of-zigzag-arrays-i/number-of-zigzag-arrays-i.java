class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        // dp[i][dir][x] = number of arrays of length i ending at value x
        // dir = 0 (last move was down), dir = 1 (last move was up)
        int[][] dpDown = new int[m][n + 1];
        int[][] dpUp = new int[m][n + 1];

        // Initialization: arrays of length 1
        for (int x = 0; x < m; x++) {
            dpDown[x][1] = 1;
            dpUp[x][1] = 1;
        }

        for (int len = 1; len < n; len++) {
            // prefix sums for dpUp (to extend with down moves)
            long[] prefix = new long[m + 1];
            for (int x = 0; x < m; x++) {
                prefix[x + 1] = (prefix[x] + dpUp[x][len]) % MOD;
            }

            // suffix sums for dpDown (to extend with up moves)
            long[] suffix = new long[m + 1];
            for (int x = m - 1; x >= 0; x--) {
                suffix[x] = (suffix[x + 1] + dpDown[x][len]) % MOD;
            }

            for (int y = 0; y < m; y++) {
                // extend with down move (must come from smaller x)
                dpDown[y][len + 1] = (int) prefix[y];
                // extend with up move (must come from larger x)
                dpUp[y][len + 1] = (int) suffix[y + 1];
            }
        }

        long ans = 0;
        for (int x = 0; x < m; x++) {
            ans = (ans + dpDown[x][n]) % MOD;
            ans = (ans + dpUp[x][n]) % MOD;
        }
        return (int) ans;
    }
}