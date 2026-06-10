class SparseTableRMQ {
    int n;                  // Size of the array
    int maxLog;             // Maximum power of 2 needed
    int[][] fMax;           // Sparse table for maximum queries
    int[][] fMin;           // Sparse table for minimum queries
    int[] lg;               // Precomputed logarithms

    // Constructor: builds sparse tables for max and min
    public SparseTableRMQ(int[] data) {
        this.n = data.length;
        this.maxLog = 32 - Integer.numberOfLeadingZeros(n) + 1;
        this.fMax = new int[n][maxLog];
        this.fMin = new int[n][maxLog];
        this.lg = new int[n + 1];

        // Precompute logarithms
        for (int i = 2; i <= n; i++) {
            this.lg[i] = this.lg[i >> 1] + 1;
        }

        // Initialize base case (interval length = 1)
        for (int i = 0; i < n; i++) {
            this.fMax[i][0] = data[i];
            this.fMin[i][0] = data[i];
        }

        // Build sparse tables
        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i <= n - (1 << j); i++) {
                this.fMax[i][j] = Math.max(
                    this.fMax[i][j - 1],
                    this.fMax[i + (1 << (j - 1))][j - 1]
                );
                this.fMin[i][j] = Math.min(
                    this.fMin[i][j - 1],
                    this.fMin[i + (1 << (j - 1))][j - 1]
                );
            }
        }
    }

    // Query maximum in range [l, r]
    public int queryMax(int l, int r) {
        int k = lg[r - l + 1];
        return Math.max(fMax[l][k], fMax[r - (1 << k) + 1][k]);
    }

    // Query minimum in range [l, r]
    public int queryMin(int l, int r) {
        int k = lg[r - l + 1];
        return Math.min(fMin[l][k], fMin[r - (1 << k) + 1][k]);
    }
}

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SparseTableRMQ st = new SparseTableRMQ(nums);

        // Max-heap: stores {value, leftIndex, rightIndex}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(b[0], a[0])
        );

        // Initialize heap with subarrays [l..n-1]
        for (int l = 0; l < n; l++) {
            long val = st.queryMax(l, n - 1) - st.queryMin(l, n - 1);
            pq.offer(new long[] {val, l, n - 1});
        }

        long ans = 0;

        // Extract top k distinct subarray values
        for (int i = 0; i < k; i++) {
            long[] curr = pq.poll();
            long val = curr[0];
            int l = (int) curr[1];
            int r = (int) curr[2];

            ans += val;

            // Shrink subarray from the right and push new candidate
            if (r > l) {
                long nextVal = st.queryMax(l, r - 1) - st.queryMin(l, r - 1);
                pq.offer(new long[] {nextVal, l, r - 1});
            }
        }

        return ans;
    }
}