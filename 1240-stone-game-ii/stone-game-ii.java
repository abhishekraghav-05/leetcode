class Solution {
    int n;
    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(piles, 0, 1);
    }

    public int solve(int[] piles, int i, int m) {
        if (i >= n) {
            return 0;
        }

        if (dp[i][m] != 0) {
            return dp[i][m];
        }

        int best = 0;

        for (int x = 1; x <= 2 * m && i + x <= n; x++) {
            int opponent = solve(piles, i + x, Math.max(m, x));

            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        return dp[i][m] = best;
    }
}