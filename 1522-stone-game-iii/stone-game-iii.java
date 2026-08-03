class Solution {
    Integer[] memo;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new Integer[n];

        int diff = dp(stoneValue, 0);

        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }

    private int dp(int[] stones, int i) {
        if (i >= stones.length)
            return 0;

        if (memo[i] != null)
            return memo[i];

        int best = Integer.MIN_VALUE;
        int sum = 0;

        for (int k = 0; k < 3 && i + k < stones.length; k++) {
            sum += stones[i + k];
            best = Math.max(best, sum - dp(stones, i + k + 1));
        }

        return memo[i] = best;
    }
}
        
        
        
        
        // int n = stoneValue.length;
        // int[] dp = new int[n + 1];

        // for (int i = n - 1; i >= 0; i--) {
        //     dp[i] = Integer.MIN_VALUE;
        //     int sum = 0;

        //     for (int k = 0; k < 3 && i + k < n; k++) {
        //         sum += stoneValue[i + k];
        //         dp[i] = Math.max(dp[i], sum - dp[i + k + 1]);
        //     }
        // }

        // if (dp[0] > 0) return "Alice";
        // if (dp[0] < 0) return "Bob";
        // return "Tie";
//     }
// }