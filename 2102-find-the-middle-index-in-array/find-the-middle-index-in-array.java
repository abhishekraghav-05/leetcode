class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++) {
            int rightSum = sum - nums[i] - leftSum;

            if(leftSum == rightSum) return i;

            leftSum += nums[i];
        }

        return -1;
    }
}