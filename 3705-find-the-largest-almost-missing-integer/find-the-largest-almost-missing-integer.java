class Solution {
    public int largestInteger(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[51];

        // Check every subarray of size k
        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    count[nums[j]]++;
                    seen[nums[j]] = true;
                }
            }
        }

        int max = -1;

        // Find largest number appearing in exactly one subarray
        for (int i = 0; i <= 50; i++) {
            if (count[i] == 1) {
                max = Math.max(max, i);
            }
        }

        return max;
    }
}