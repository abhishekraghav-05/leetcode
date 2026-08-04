class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evenSum = 0, oddSum = 0;
        for(int i = 1; i <= 2*n; i++) {
            if(i % 2 == 0) {
                evenSum += i;
            }else {
                oddSum += i;
            }
        }

        return gcd(oddSum, evenSum);
    }

    public int gcd(int num1, int num2) {
        if(num1 == 0) return num2;

        return gcd(num2 % num1, num1);
    }
}