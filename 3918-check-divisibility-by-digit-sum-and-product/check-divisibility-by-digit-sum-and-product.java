class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int digitSum = 0; 
        long digitProduct = 1;
        
        while(num > 0) {
            int digit = num % 10;
            digitSum += digit;
            digitProduct *= digit;

            num /= 10;
        }

        return (n % (digitSum + digitProduct) == 0);
    }
}