class Solution {
    public int subtractProductAndSum(int n) {
        int num = n;
        int sum = 0, pro = 1;
        
        while(num > 0) {
            int digit = num % 10;
            pro *= digit;
            sum += digit;
            num /= 10;
        }

        return pro - sum;
    }
}