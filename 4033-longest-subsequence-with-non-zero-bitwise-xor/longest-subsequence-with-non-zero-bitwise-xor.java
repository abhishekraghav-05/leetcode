class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int subseq = 0;
        int count = n; 
        boolean nonZero = false;

        for(int num : nums) {
            subseq ^= num;

            if (num != 0) {
                nonZero = true;
            }
        }

        // for(int i = n - 1; i > 0; i--) {
            if(subseq > 0) {
                return count;
            }
        //     subseq ^= nums[i];
        //     count--;
        // }

        if (nonZero) {
            return n - 1;
        }

        return 0;
    }
}