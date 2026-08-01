class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length - 1;
        
        if(dp(nums, 0, n) >= 0) return true;

        return false;
    }
    public int dp(int[] nums, int i, int j) {
        int n = nums.length - 1;
        
        if(i == j) return nums[i];

        if(i > j) return 0;

        int left = nums[i] - dp(nums, i + 1, j);

        int right = nums[j] - dp(nums, i, j - 1);

        return Math.max(left, right);
    }
}