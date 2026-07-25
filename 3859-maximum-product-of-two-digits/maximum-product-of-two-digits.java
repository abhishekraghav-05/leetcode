class Solution {
    public int maxProduct(int n) {
        int maxProduct = Integer.MIN_VALUE;
        while (n > 9) {
            int digit = n % 10;
            n = n / 10;
            
            int product = maxInAll(n, digit);
            maxProduct = Math.max(product, maxProduct);
        }

        return maxProduct;
    }

    public int maxInAll(int n, int digit) {
        int maxProduct = Integer.MIN_VALUE;
        while(n > 0) {
            int product = digit * (n % 10);
            n = n / 10;
            maxProduct = Math.max(product, maxProduct);
        }

        return maxProduct;
    }
}