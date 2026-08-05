class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int validCount = 0;
        for(int i = 0; i < n; i++) {
            int j = i;
            int x = 0, y = 0;
            while(j < n) {
                if(nums[j] % 2 == 0) {
                    x++;
                }else {
                    y++;
                }
                j++;
                if(y > 0 && (x * b) <= (a * y)) {
                    validCount++;
                }
            }
        }

        return validCount;
    }
}