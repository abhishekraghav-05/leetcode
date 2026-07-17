class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // freq[x] = frequency of x
        long[] freq = new long[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // cnt[d] = count of numbers divisible by d
        long[] cnt = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                cnt[d] += freq[multiple];
            }
        }

        // exact[d] = number of pairs whose gcd is exactly d
        long[] exact = new long[max + 1];
        for (int d = max; d >= 1; d--) {
            exact[d] = cnt[d] * (cnt[d] - 1) / 2;
            for (int multiple = d * 2; multiple <= max; multiple += d) {
                exact[d] -= exact[multiple];
            }
        }

        // prefix[d] = number of pairs with gcd <= d
        long[] prefix = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            prefix[d] = prefix[d - 1] + exact[d];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;
            int left = 1, right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left;
        }

        return ans;
    }
}

//         int n = nums.length;

//         long size = (n - 3) * 5/10;
//         long[] gcdPairs = new long[size];
//         int index = 0;

//         for(int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 gcdPairs[index] = gcd(nums[i], nums[j]);
//                 index++;
//             }
//         }
//         Arrays.sort(gcdPairs);

//         int[] answer = new int[queries.length];
//         for(int i = 0; i < queries.length; i++) {
//             answer[i] = gcdPairs[queries[i]];
//         }

//         return answer;
//     }

//     public int gcd(int a, int b) {
//         if(a == 0) return b;
//         return gcd(b % a, a);
//     }
// }