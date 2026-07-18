class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length, count = 0;
        int mid = (n - 1) / 2;
        for(int i = 0; i < n; i++) {
            if(nums[mid] == nums[i]) count++;
        }

        if(count == 1) return true;
        return false;
    }
}