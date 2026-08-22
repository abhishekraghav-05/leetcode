class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0, pro = 1;

        while(num > 0) {
            int d = num % 10;
            sum += d;
            pro *= d;
            num /= 10; 
        }

        return (n % (sum + pro) == 0); 
    }
}