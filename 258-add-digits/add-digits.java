class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        
        int add = 0;
        while(num > 9) {
            add = sum(num);
            num = add;
        }

        return num;
    }

    public int sum(int n) {
        int sum = 0;
        while(n > 0) {
            sum = sum + (n % 10);
            n /= 10;
        }

        return sum;
    }
}