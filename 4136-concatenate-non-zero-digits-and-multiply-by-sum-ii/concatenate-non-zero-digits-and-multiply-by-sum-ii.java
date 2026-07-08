class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        long[] sumPre = new long[n + 1]; // prefix sum of digits
        long[] val = new long[n + 1];    // non-zero digits concatenated, mod MOD
        int[] cnt = new int[n + 1];      // count of non-zero digits

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            sumPre[i + 1] = sumPre[i] + d;
            if (d != 0) {
                val[i + 1] = (val[i] * 10 + d) % MOD;
                cnt[i + 1] = cnt[i] + 1;
            } else {
                val[i + 1] = val[i];
                cnt[i + 1] = cnt[i];
            }
        }

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = pow10[i - 1] * 10 % MOD;
        }

        int m = queries.length;
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long sum = sumPre[r + 1] - sumPre[l];
            int k = cnt[r + 1] - cnt[l];
            long x = ((val[r + 1] - val[l] * pow10[k]) % MOD + MOD) % MOD;
            answer[i] = (int) (x * (sum % MOD) % MOD);
        }
        return answer;
    }
}

//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int[] nums = new int[queries.length];
//         for (int i = 0; i < queries.length; i++) {
//             String sub = s.substring(queries[i][0], queries[i][1] + 1); 
//             nums[i] = nonZero(sub);
//         }
//         return nums;
//     }

//     public int nonZero(String s) {
//         long x = 0;
//         int sum = 0;

//         for (char c : s.toCharArray()) {
//             int digit = c - '0';
//             if (digit != 0) {
//                 x = (x * 10 + digit) % MOD; 
//                 sum = (sum + digit) % MOD;
//             }
//         }

//         return (int) ((x * sum) % MOD);
//     }
// }
