class Solution {
    public int maximumLength(int[] nums) {
        
        Map<Long, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put((long) num, count.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special case for 1's
        if (count.containsKey(1L)) {
            int c1 = count.get(1L);
            ans = Math.max(ans, c1 - (c1 % 2 == 0 ? 1 : 0));
        }

        for (long num : count.keySet()) {
            if (num == 1) continue;
            long curr = num;
            int length = 0;

            while (count.getOrDefault(curr, 0) >= 2 && count.containsKey(curr * curr)) {
                length += 2;
                curr = curr * curr;
                if (curr > 1e9) break; // avoid overflow
            }

            // Add peak if current exists
            if (count.getOrDefault(curr, 0) >= 1) {
                length += 1;
            }

            ans = Math.max(ans, length);
        }
        return ans;
    }
}