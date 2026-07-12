class Solution {
    public int minimumCost(int[] nums, int k) {
        long mod = 1_000_000_007;
        long INV2 = 500000004L;

        long availableResources = k;
        long cost = 0;
        long operations = 0;

        for(int num : nums) {
            while(availableResources < num) {
                long need = (num - availableResources + k - 1) / k;
                
                // Sum of (operations+1) ... (operations+need) <- (first+Last)*Term/2
                long a = (2L * operations + need + 1) % mod;
                long b = need % mod;

                long sum = (a * b) % mod;
                sum = (sum * INV2) % mod;

                cost = (cost + sum) % mod;
       

                operations += need;
                availableResources += need * k;
            }
            availableResources -= num;
        }

        return (int) (cost % mod);
    }
}