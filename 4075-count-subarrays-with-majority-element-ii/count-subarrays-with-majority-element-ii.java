class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] balance = new int[n];
        for (int i = 0; i < n; i++) {
            balance[i] = (nums[i] == target ? 1 : -1);
        }

        // prefix sums
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + balance[i];
        }

        // coordinate compression
        long[] sorted = prefix.clone();
        Arrays.sort(sorted);
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i + 1); // 1-based index for Fenwick
        }

        Fenwick fenwick = new Fenwick(sorted.length);
        long result = 0;

        for (long p : prefix) {
            int idx = map.get(p);
            // count how many previous prefix sums < current
            result += fenwick.query(idx - 1);
            fenwick.update(idx, 1);
        }

        return result;
    }

    // Fenwick Tree (BIT)
    static class Fenwick {
        long[] bit;
        Fenwick(int n) { bit = new long[n + 1]; }
        void update(int i, long val) {
            while (i < bit.length) {
                bit[i] += val;
                i += i & -i;
            }
        }
        long query(int i) {
            long sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}