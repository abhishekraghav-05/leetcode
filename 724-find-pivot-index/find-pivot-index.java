class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        long leftSum = 0, sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        for(int i = 0; i < n; i++) {
            long rightSum = sum - leftSum - nums[i];

            if(leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        
        return -1; 
    }
}