class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n];
        int compId = 0;
        comp[0] = compId;

        // Build connected components
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                comp[i] = compId; // same component
            } else {
                compId++;         // new component
                comp[i] = compId;
            }
        }

        // Answer queries
        int m = queries.length;
        boolean[] answer = new boolean[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0], v = queries[i][1];
            answer[i] = (comp[u] == comp[v]);
        }
        return answer;
    }
}
