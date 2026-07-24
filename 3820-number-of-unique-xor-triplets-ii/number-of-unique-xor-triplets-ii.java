class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        final int MAX = 2048;

        boolean[] dp1 = new boolean[MAX];
        boolean[] dp2 = new boolean[MAX];
        boolean[] dp3 = new boolean[MAX];

        for (int x : nums) {
           dp1[x] = true;
        } 

        for (int x : nums) {
            for (int v = 0; v < MAX; v++) {
                if (dp1[v]) {
                    dp2[v ^ x] = true;
                }
            }
        }

        for (int x : nums) {
            for (int v = 0; v < MAX; v++) {
                if (dp2[v]) {
                    dp3[v ^ x] = true;
                }
            }
        }

        int ans = 0;
        for (boolean b : dp3) {
            if (b) ans++;
        }
        return ans;
    }
}