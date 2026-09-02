class Solution {
    public boolean uniformArray(int[] nums1) {

        int n = nums1.length;
        int oddCount = 0;

        for (int num : nums1) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        // All even
        if (oddCount == 0) {
            return true;
        }

        // Exactly one odd -> make all odd
        if (oddCount == 1) {
            return true;
        }

        // At least two odd -> make all even
        return true;


        
        
        // int n = nums1.length;
        // int[] nums2 = new int[n];
        // for(int i = 0; i < n; i++) {
        //     if(nums1[i] % 2 == 0) {
        //         nums2[i] = nums1[i];
        //     } else if((i < n - 1) && (nums1[i] - nums1[i + 1]) % 2 == 0) {
        //         nums2[i] = nums1[i] - nums1[i + 1];
        //     }else {
        //         break;
        //     }
        // }

        // for(int i = 0; i < n; i++) {
        //     if(nums1[i] % 3 == 0) {
        //         nums2[i] = nums1[i];
        //     }else if(((i < n - 1) && nums1[i] - nums1[i + 1]) % 3 == 0) {
        //         nums2[i] = nums1[i] - nums1[i + 1];
        //     }else {
        //         return false;
        //     }
        // }

        // return true;
    }
}