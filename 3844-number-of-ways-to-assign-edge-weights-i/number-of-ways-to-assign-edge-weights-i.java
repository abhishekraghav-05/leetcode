class Solution {
    static final int MOD = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        // DFS to find max depth
        int maxDepth = dfs(graph, 1, -1);
        return modPow(2, maxDepth - 1, MOD);
    }

    private int dfs(List<Integer>[] graph, int node, int parent) {
        int depth = 0;
        for (int nei : graph[node]) {
            if (nei != parent) {
                depth = Math.max(depth, 1 + dfs(graph, nei, node));
            }
        }
        return depth;
    }

    private int modPow(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}
