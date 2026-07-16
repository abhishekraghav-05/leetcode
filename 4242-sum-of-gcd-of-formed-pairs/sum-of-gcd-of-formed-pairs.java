class Solution {
    public long gcdSum(int[] nums) {
        int maxElement = 0;
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int i = 0, j = n - 1;
        long sumGcd = 0;

        for(int index = 0; index < n; index++) {
            maxElement = Math.max(maxElement, nums[index]);
            prefixGcd[index] = gcd(nums[index], maxElement);
        }

        Arrays.sort(prefixGcd);

        while(i < j) {
            sumGcd += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }

        return sumGcd;
    }

    public int gcd(int num1, int num2) {
        if(num1 == 0) return num2;

        return gcd((num2 % num1), num1);
    }
}