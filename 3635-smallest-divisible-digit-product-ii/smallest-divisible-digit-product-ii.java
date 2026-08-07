class Solution {

    static final int INF = 1_000_000;

    int a, b, c, d;
    int[] dp;

    // Prime factor counts for digits 0..9
    int[] f2 = {0, 0, 1, 0, 2, 0, 1, 0, 3, 0};
    int[] f3 = {0, 0, 0, 1, 0, 0, 1, 0, 0, 2};
    int[] f5 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
    int[] f7 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};

    public String smallestNumber(String num, long t) {

        int[] primes = {2, 3, 5, 7};
        int[] cnt = new int[4];

        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                cnt[i]++;
                t /= primes[i];
            }
        }

        if (t != 1) {
            return "-1";
        }

        a = cnt[0];
        b = cnt[1];
        c = cnt[2];
        d = cnt[3];

        buildDP();

        int n = num.length();

        int[][] pref = new int[4][n + 1];
        boolean[] zero = new boolean[n + 1];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 4; j++) {
                pref[j][i + 1] = pref[j][i];
            }

            zero[i + 1] = zero[i];

            int digit = num.charAt(i) - '0';

            if (digit == 0) {
                zero[i + 1] = true;
            } else {
                pref[0][i + 1] += f2[digit];
                pref[1][i + 1] += f3[digit];
                pref[2][i + 1] += f5[digit];
                pref[3][i + 1] += f7[digit];
            }
        }

        // num itself is valid
        if (!zero[n]
                && pref[0][n] >= a
                && pref[1][n] >= b
                && pref[2][n] >= c
                && pref[3][n] >= d) {
            return num;
        }

        // Same length
        for (int i = n - 1; i >= 0; i--) {

            if (zero[i]) {
                continue;
            }

            int current = num.charAt(i) - '0';

            for (int digit = current + 1; digit <= 9; digit++) {

                int need2 = Math.max(0,
                        a - pref[0][i] - f2[digit]);

                int need3 = Math.max(0,
                        b - pref[1][i] - f3[digit]);

                int need5 = Math.max(0,
                        c - pref[2][i] - f5[digit]);

                int need7 = Math.max(0,
                        d - pref[3][i] - f7[digit]);

                int remaining = n - i - 1;

                if (getDP(need2, need3, need5, need7) <= remaining) {

                    StringBuilder ans = new StringBuilder(n);

                    ans.append(num, 0, i);
                    ans.append((char) ('0' + digit));

                    buildSmallest(
                            ans,
                            remaining,
                            need2,
                            need3,
                            need5,
                            need7
                    );

                    return ans.toString();
                }
            }
        }

        // Longer number
        int minDigits = getDP(a, b, c, d);

        if (minDigits == INF) {
            return "-1";
        }

        int length = Math.max(n + 1, minDigits);

        StringBuilder ans = new StringBuilder(length);

        buildSmallest(
                ans,
                length,
                a,
                b,
                c,
                d
        );

        return ans.toString();
    }

    private void buildDP() {

        int B = b + 1;
        int C = c + 1;
        int D = d + 1;

        int size = (a + 1) * B * C * D;

        dp = new int[size];

        java.util.Arrays.fill(dp, INF);

        dp[index(0, 0, 0, 0)] = 0;

        for (int x2 = 0; x2 <= a; x2++) {
            for (int x3 = 0; x3 <= b; x3++) {
                for (int x5 = 0; x5 <= c; x5++) {
                    for (int x7 = 0; x7 <= d; x7++) {

                        if (x2 == 0 && x3 == 0 &&
                            x5 == 0 && x7 == 0) {
                            continue;
                        }

                        int best = INF;

                        for (int digit = 2; digit <= 9; digit++) {

                            int p2 = Math.max(0, x2 - f2[digit]);
                            int p3 = Math.max(0, x3 - f3[digit]);
                            int p5 = Math.max(0, x5 - f5[digit]);
                            int p7 = Math.max(0, x7 - f7[digit]);

                            int previous =
                                    dp[index(p2, p3, p5, p7)];

                            if (previous != INF) {
                                best = Math.min(best, previous + 1);
                            }
                        }

                        dp[index(x2, x3, x5, x7)] = best;
                    }
                }
            }
        }
    }

    private void buildSmallest(
            StringBuilder ans,
            int length,
            int need2,
            int need3,
            int need5,
            int need7) {

        for (int pos = 0; pos < length; pos++) {

            int remaining = length - pos - 1;

            for (int digit = 1; digit <= 9; digit++) {

                int n2 = Math.max(0, need2 - f2[digit]);
                int n3 = Math.max(0, need3 - f3[digit]);
                int n5 = Math.max(0, need5 - f5[digit]);
                int n7 = Math.max(0, need7 - f7[digit]);

                if (getDP(n2, n3, n5, n7) <= remaining) {

                    ans.append((char) ('0' + digit));

                    need2 = n2;
                    need3 = n3;
                    need5 = n5;
                    need7 = n7;

                    break;
                }
            }
        }
    }

    private int getDP(int x2, int x3, int x5, int x7) {
        return dp[index(x2, x3, x5, x7)];
    }

    private int index(int x2, int x3, int x5, int x7) {

        int B = b + 1;
        int C = c + 1;
        int D = d + 1;

        return (((x2 * B) + x3) * C + x5) * D + x7;
    }
}