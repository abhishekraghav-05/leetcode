class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += encrypt(num);
        }

        return sum;
    }

    private int encrypt(int num) {
        int n = num;
        int maxDigit = 0, count = 0, newNum = 0;
        
        while(n > 0) {
            maxDigit = Math.max(maxDigit, (n % 10));
            count++;
            n /= 10;
        }

        while(count > 0) {
            newNum = (newNum * 10) + maxDigit;
            count--;
        }

        return newNum;
    }
}