class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        
        int[] prefix = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : 0);
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                int countTarget = prefix[j + 1] - prefix[i];
                if (countTarget > len / 2) {
                    result++;
                }
            }
        }
        return result;
    }
}