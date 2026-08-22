class Solution {
    public long sumDigitDifferences(int[] nums) {
        long sum = 0;
        int n = nums.length;

        while(nums[0] > 0) {
            int[] count = new int[10];

            for(int i = 0; i < n; i++) {
                count[nums[i] % 10]++;
                nums[i] /= 10;
            }

            int digitDiff = 0;
            for(int digit = 0; digit < 10; digit++) {
                sum += (long) count[digit] * digitDiff;
                digitDiff += count[digit];
            }
        }

        return sum;
    }
}



//         long sum = 0;

//         for(int i = 0; i < nums.length - 1; i++) {
//             for(int j = i + 1; j < nums.length; j++) {
//                 sum += digitDiff(nums[i], nums[j]);
//             }
//         }

//         return sum;
//     }

//     private int digitDiff(int n1, int n2) {
//         int count = 0;
//         while(n1 > 0 && n2 > 0) {
//             if((n1 % 10) != (n2 % 10)) count++;
//             n1 /= 10;
//             n2 /= 10;
//         }

//         return count;
//     }
// }