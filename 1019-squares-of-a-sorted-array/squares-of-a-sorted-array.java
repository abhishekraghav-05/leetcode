class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int pos = n - 1; // fill result from the end

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos--] = leftSquare;
                left++;
            } else {
                result[pos--] = rightSquare;
                right--;
            }
        }
        return result;

        // ArrayList<Integer> pos = new ArrayList<>();
        // ArrayList<Integer> neg = new ArrayList<>();
        // int n = nums.length;
        // for(int i = 0; i < n; i++) {
        //     if(nums[i] > 0) {
        //         neg.add(nums[i]);
        //     }else{
        //         pos.add(nums[i]);
        //     }
        // }
        // int m = pos.length;
        // int n = neg.length;
        // if(pos.length < 0) {
        //     for(int i = 0; i < n; i++) {
        //         nums[n - i - 1] = nums[i] * nums[i];
        //         return nums;
        //     }
        // }else if(neg.length < 0) {
        //     for(int i = 0; i < n; i++) {
        //         nums[i] = nums[i] * nums[i];
        //         return nums;
        //     }
        // }else{

        // }
    }
}