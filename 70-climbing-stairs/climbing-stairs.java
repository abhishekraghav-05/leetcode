class Solution {
    int [] dp;
    public int climbStairs(int n) {
        if(n <= 3) return n;

        dp = new int[n + 1];

        return climbCount(n);
    }

    public int climbCount(int n) {
        if(n <= 3) return n;

        if(dp[n] != 0) return dp[n];

        dp[n] = climbCount(n - 1) + climbCount(n - 2);

        return dp[n];
    }
}