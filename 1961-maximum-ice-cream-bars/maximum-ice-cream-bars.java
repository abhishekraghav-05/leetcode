class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);                // nlogn

        int i = 0, count = 0;
        while (i < costs.length) {
            if(coins >= costs[i]) {
                count++;
                coins -= costs[i];
            }else {
                break;
            }
            i++;
        }

        return count;
    }
}