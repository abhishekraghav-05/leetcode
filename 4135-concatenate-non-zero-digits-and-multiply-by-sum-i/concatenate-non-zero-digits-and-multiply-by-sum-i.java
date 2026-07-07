class Solution {
    public long sumAndMultiply(int n) {
        int x = 0, sum = 0;
        int power = 0;
        while(n > 0) {
            int digit = n % 10;
            if(digit != 0) {
                sum += digit;

                x += digit * (int) Math.pow(10, power);
                power++;
            }
            n = n / 10;
        }
        return (long) x * sum;
    }
}