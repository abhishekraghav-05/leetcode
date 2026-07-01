class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        // Multi-source BFS from thieves
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && dist[ni][nj] == Integer.MAX_VALUE) {
                    dist[ni][nj] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        // Binary search on safeness factor
        int low = 0, high = n * 2; // max possible distance
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canReach(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canReach(int[][] dist, int k) {
        int n = dist.length;
        if (dist[0][0] < k) return false;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n-1 && cur[1] == n-1) return true;
            for (int[] d : dirs) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj] && dist[ni][nj] >= k) {
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        return false;
    }
}