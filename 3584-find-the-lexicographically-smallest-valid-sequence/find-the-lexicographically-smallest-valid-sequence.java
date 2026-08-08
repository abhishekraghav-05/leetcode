class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] dp = new int[n + 1];

        // dp[i] = longest suffix of word2 that can be
        // matched in word1[i...]
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // Greedily find the lexicographically smallest sequence
        while (i < n && j < m) {

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } else {
                // Use the one allowed mismatch
                if (dp[i + 1] >= m - j - 1) {
                    ans[j] = i;
                    j++;
                    i++;

                    // Continue with exact matching
                    break;
                }
            }

            i++;
        }

        if (j < m && i == n) {
            return new int[0];
        }

        // Match the remaining characters exactly
        while (j < m && i < n) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }

            i++;
        }

        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}