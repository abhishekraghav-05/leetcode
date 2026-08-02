class Solution {
    // private Integer[][] memo;
    public boolean stoneGame(int[] piles) {
        return true;
    }
}


//         int n = piles.length;
//         memo = new Integer[n][n];
//         if(dp(piles, 0, n - 1) > 0) return true;

//         return false;
//     }

//     public int dp(int[] nums, int i, int j) {
//         if(i > j) {
//             return 0; 
//         }
        
//         if(memo[i][j] != null) {
//             return memo[i][j];
//         }
//         int left = nums[i] - dp(nums, i + 1, j);
//         int right = nums[j] - dp(nums, i, j - 1);

//         int max = Math.max(left, right);
//         memo[i][j] = max;

//         return max;
//     }
// }


        // int n = piles.length;
        // int[][] dp = new int[n][n];

        // // Base case
        // for (int i = 0; i < n; i++) {
        //     dp[i][i] = piles[i];
        // }

        // // Build for larger subarrays
        // for (int len = 2; len <= n; len++) {
        //     for (int i = 0; i + len - 1 < n; i++) {
        //         int j = i + len - 1;

        //         int left = piles[i] - dp[i + 1][j];
        //         int right = piles[j] - dp[i][j - 1];

        //         dp[i][j] = Math.max(left, right);
        //     }
        // }

        // return dp[0][n - 1] >= 0;
//     }
// }