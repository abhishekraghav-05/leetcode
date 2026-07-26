class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        int firstMax =  Integer.MIN_VALUE;
        int secondMax =  Integer.MIN_VALUE;
        int thirdMax =  Integer.MIN_VALUE;

        int firstMin =  Integer.MAX_VALUE;
        int secondMin =  Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            
            if(firstMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];

            }else if(secondMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = nums[i];
            }else if(thirdMax < nums[i]) {
                thirdMax = nums[i];
            }

            if(firstMin > nums[i]) {
                secondMin = firstMin;
                firstMin = nums[i];
            }else if(secondMin > nums[i]) {
                secondMin = nums[i];
            }
        }

        int minProduct = firstMax * firstMin * secondMin;
        int maxProduct = firstMax * secondMax * thirdMax;
        
        return Math.max(minProduct, maxProduct);
    }
}