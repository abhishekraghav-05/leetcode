class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, odd = 1;
        int sumEven = 0, even = 2;
        for(int i = 1; i <= n; i++) {
            sumOdd += odd;
            odd += 2;
            sumEven += even;
            even += 2;
        }

        return gcd(sumOdd, sumEven);
    }

    public int gcd(int num1, int num2) {
        if(num1 == 0) return num2;
        
        return gcd((num2 % num1), num1);
    }
}