class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        // Step 1: Build prefix products
        int[] prefix = new int[n];
        prefix[0] = 1; // nothing before first element
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // Step 2: Build suffix products
        int[] suffix = new int[n];
        suffix[n - 1] = 1; // nothing after last element
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        // Step 3: Multiply prefix and suffix for result
        for (int i = 0; i < n; i++) {
            output[i] = prefix[i] * suffix[i];
        }
        return output;
    }
}