class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // [value, original index]
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int start = 0;

        while (start < n) {

            int end = start;

            // Find all values in the same group
            while (end + 1 < n &&
                   (long) arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            // Store original indices of this group
            int size = end - start + 1;
            int[] indices = new int[size];

            for (int i = 0; i < size; i++) {
                indices[i] = arr[start + i][1];
            }

            // Smallest index gets smallest value
            Arrays.sort(indices);

            for (int i = 0; i < size; i++) {
                nums[indices[i]] = arr[start + i][0];
            }

            start = end + 1;
        }

        return nums;
    }
}




//         int n = nums.length;
//         int max = Integer.MIN_VALUE;
//         int min = Integer.MAX_VALUE;

//         for(int j = 0; j < n; j++) {
//             max = Math.max(max, nums[j]);
//             min = Math.min(min, nums[j]);
//         }

//         if(max - (min + limit) == 0) {
//             if(max - min == n) {
//                 for(int i = 0; i < n; i++) {
//                     int index = nums[i] - min;
//                     nums[index] = nums[i];
//                 }
//             }else if(min % 10 == 0){
//                 for(int i = 0; i < n; i++) {
//                     int index = (nums[i] - min) / min;
//                     nums[index] = nums[i];
//                 }
//             }else {
//                 for(int i = 0; i < n; i++) {
//                     int index = (nums[i] % min) / min;
//                     nums[index] = nums[i];
//                 }
//             }
//         }else {
        
//             for(int i = 0; i < n - 1; i++) {
//                 int j = i + 1;
//                 int diff = Math.abs(nums[i] - nums[j]);

//                 if(diff <= limit) {
//                     int temp = nums[i];
//                     nums[i] = nums[j];
//                     nums[j] = temp;
//                 }
//             }   
//         }

//         if(min != nums[0] && max != nums[n-1])
//         for(int i = 0; i < n - 1; i++) {
//             for(int j = i + 1; j < n; j++) {
//                 int diff = Math.abs(nums[i] - nums[j]);

//                 if(diff <= limit) {
//                     int temp = nums[i];
//                     nums[i] = nums[j];
//                     nums[j] = temp;
//                 }   
//             }
//         }

//         return nums;
//     }
// }                                                                                                     