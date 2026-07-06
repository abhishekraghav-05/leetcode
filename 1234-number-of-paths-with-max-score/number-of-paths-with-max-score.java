class Solution {
    private static final int MOD = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] maxScore = new int[n][n];
        int[][] pathCount = new int[n][n];

        // Initialize with -1 for unreachable cells
        for (int i = 0; i < n; i++) {
            Arrays.fill(maxScore[i], -1);
        }

        // Start at 'S'
        maxScore[n - 1][n - 1] = 0;
        pathCount[n - 1][n - 1] = 1;

        // Traverse from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') continue;
                if (i == n - 1 && j == n - 1) continue;

                int bestScore = -1;
                int ways = 0;

                // Possible moves: down, right, diagonal down-right
                int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};
                for (int[] d : dirs) {
                    int x = i + d[0], y = j + d[1];
                    if (x < n && y < n && maxScore[x][y] != -1) {
                        int score = maxScore[x][y];
                        if (score > bestScore) {
                            bestScore = score;
                            ways = pathCount[x][y];
                        } else if (score == bestScore) {
                            ways = (ways + pathCount[x][y]) % MOD;
                        }
                    }
                }

                if (bestScore == -1) continue;

                int val = 0;
                char c = board.get(i).charAt(j);
                if (Character.isDigit(c)) {
                    val = c - '0';
                }
                maxScore[i][j] = bestScore + val;
                pathCount[i][j] = ways;
            }
        }

        if (maxScore[0][0] == -1) return new int[]{0, 0};
        return new int[]{maxScore[0][0], pathCount[0][0]};
    }
}