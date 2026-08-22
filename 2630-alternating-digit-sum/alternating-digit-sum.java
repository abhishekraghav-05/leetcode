class Solution {
    public int alternateDigitSum(int n) {
        int count = 0, result = 0;
        int num = n;
        while(n > 0) {
            count++;
            n /= 10;
        }

        while(num > 0) {
            int d = num % 10;
            if(count % 2 == 0) {
                result -= d;
            }else {
                result += d;
            }
            count--;
            num /= 10;
        }

        return result;
    }
}