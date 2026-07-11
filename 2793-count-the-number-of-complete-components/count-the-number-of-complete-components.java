class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                dfs(i, adj, visited, comp);
                
                int nodes = comp.size();
                int edgeCount = 0;
                for (int u : comp) edgeCount += adj.get(u).size();
                
                edgeCount /= 2; // each edge counted twice
                if (edgeCount == nodes * (nodes - 1) / 2) {
                    result++;
                }
            }
        }
        return result;
    }
    
    private void dfs(int u, List<List<Integer>> adj, boolean[] visited, List<Integer> comp) {
        visited[u] = true;
        comp.add(u);
        for (int v : adj.get(u)) {
            if (!visited[v]) dfs(v, adj, visited, comp);
        }
    }
}