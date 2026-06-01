class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int minCost = 0;
        for(int i = 0; i < cost.length; i++) {
            minCost += cost[i]; 
        }
        for(int i = cost.length - 1; i > 1; i -= 3) {
            if(cost.length > 2) {
                minCost -= cost[i-2];
            }
        }    
        return minCost;    
    }
}   






















