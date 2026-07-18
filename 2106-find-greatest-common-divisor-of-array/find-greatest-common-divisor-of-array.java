class Solution {
    public int findGCD(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            minNum = Math.min(minNum, nums[i]);
            maxNum = Math.max(maxNum, nums[i]);
        }
        
        int maxMinGcd = gcd(maxNum, minNum);

        return maxMinGcd;
    }

    public int gcd(int num1, int num2) {
        if(num1 == 0) return num2;
        return gcd((num2 % num1), num1);
    }
}