class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n], rightSum = new int[n];
        leftSum[0] = 0;
        rightSum[n - 1] = 0;
        int diff = 0, sum1 = 0, sum2 = 0;
        for(int i = 0; i < n-1; i++) {
            sum1 += nums[i];
            leftSum[i+1] = sum1;
            sum2 += nums[n-i-1];
            rightSum[n-i-2] = sum2;
        }

        for(int i = 0; i < n; i++) {
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return nums;
    }
}