class Solution {
    
    static class State {
        long score;
        int[] ids;

        State(long score, int[] ids) {
            this.score = score;
            this.ids = ids;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        
        int n = intervals.size();

        // [left, right, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by ending position
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // prev[i] = last interval ending before arr[i] starts
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {

            int left = arr[i][0];

            int lo = 0;
            int hi = i - 1;
            int ans = -1;

            while (lo <= hi) {

                int mid = lo + (hi - lo) / 2;

                if (arr[mid][1] < left) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            prev[i] = ans;
        }

        State[][] dp = new State[5][n + 1];

        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                dp[k][i] = new State(0L, new int[0]);
            }
        }

        for (int k = 1; k <= 4; k++) {

            for (int i = 1; i <= n; i++) {

                // Don't take current interval
                State skip = dp[k][i - 1];

                int current = i - 1;

                // Take current interval
                int p = prev[current];

                State previous;

                if (p == -1) {
                    previous = dp[k - 1][0];
                } else {
                    previous = dp[k - 1][p + 1];
                }

                long takeScore = previous.score + arr[current][2];

                int[] takeIds = new int[previous.ids.length + 1];

                for (int j = 0; j < previous.ids.length; j++) {
                    takeIds[j] = previous.ids[j];
                }

                takeIds[takeIds.length - 1] = arr[current][3];

                // At most 4 elements, so sorting is constant time
                Arrays.sort(takeIds);

                State take = new State(takeScore, takeIds);

                // Choose better score.
                // If scores are equal, choose lexicographically smaller indices.
                if (take.score > skip.score ||
                    (take.score == skip.score &&
                     isLexicographicallySmaller(take.ids, skip.ids))) {

                    dp[k][i] = take;

                } else {
                    dp[k][i] = skip;
                }
            }
        }

        return dp[4][n].ids;
    }

    private boolean isLexicographicallySmaller(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }

        return a.length < b.length;
    }
}