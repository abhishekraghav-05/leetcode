class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] count = new int[10];
        int minFreq = Integer.MAX_VALUE;
        int lessFreq = Integer.MAX_VALUE;
        int num = n;

        while(n > 0) {
            int digit = n % 10;
            count[digit]++;
            n /= 10;
        }

        while(num > 0) {
            int digit = num % 10;
            if(minFreq > count[digit]) {
                minFreq = count[digit];
                lessFreq = digit;
            }else if(minFreq == count[digit]) {
                lessFreq = Math.min(lessFreq, digit);
            }
            num /= 10;
        }

        return lessFreq;
    }
}