class Solution {
    public int smallestNumber(int n, int t) {

        while(digitProduct(n) % t != 0) {
            n++;
        }

        return n;
    }

    public int digitProduct(int n) {
        int product = 1;

        while(n > 0) {
            product *= n % 10;
            n /= 10;
        }

        return product;
    }
}