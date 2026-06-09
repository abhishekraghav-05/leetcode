class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            max = Math.max(num, max);
            
            min = Math.min(num, min);
        }
        int difference = max - min;
        return (long) k * difference;
    }
}