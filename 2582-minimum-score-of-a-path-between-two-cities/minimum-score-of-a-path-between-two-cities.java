class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        int minEdge = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] nei : graph.get(u)) {
                int v = nei[0], w = nei[1];
                minEdge = Math.min(minEdge, w);
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        
        return minEdge;
    }
}