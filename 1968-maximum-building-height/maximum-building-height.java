class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>(Arrays.asList(restrictions));
        
        // Step 1: Add building 1 restriction (height = 0)
        list.add(new int[]{1, 0});
        // Step 2: Add building n restriction (height = n-1)
        list.add(new int[]{n, n - 1});
        
        // Step 3: Sort by building index
        list.sort((a, b) -> a[0] - b[0]);
        
        // Step 4: Forward pass
        for (int i = 1; i < list.size(); i++) {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            curr[1] = Math.min(curr[1], prev[1] + (curr[0] - prev[0]));
        }
        
        // Step 5: Backward pass
        for (int i = list.size() - 2; i >= 0; i--) {
            int[] next = list.get(i + 1);
            int[] curr = list.get(i);
            curr[1] = Math.min(curr[1], next[1] + (next[0] - curr[0]));
        }
        
        // Step 6: Compute max peak
        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
            int pos1 = list.get(i - 1)[0], h1 = list.get(i - 1)[1];
            int pos2 = list.get(i)[0], h2 = list.get(i)[1];
            int dist = pos2 - pos1;
            int peak = (h1 + h2 + dist) / 2;
            ans = Math.max(ans, peak);
        }
        
        return ans;
    }
}
