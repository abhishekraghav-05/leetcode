class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        // ID of each litter cell
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);

            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } 
                else if (ch == 'L') {
                    litterId[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        int fullMask = (1 << litterCount) - 1;

        /*
         * bestEnergy[r][c][mask]
         *
         * Maximum energy with which we have reached
         * (r,c) after collecting the litter represented by mask.
         */
        int[][][] bestEnergy =
                new int[m][n][1 << litterCount];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }

        Queue<State> queue = new ArrayDeque<>();

        // Starting state
        queue.offer(new State(sr, sc, 0, energy, 0));
        bestEnergy[sr][sc][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            State cur = queue.poll();

            int r = cur.r;
            int c = cur.c;
            int mask = cur.mask;
            int e = cur.energy;
            int steps = cur.steps;

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                /*
                 * Every movement costs 1 energy.
                 *
                 * If energy is 0, the student cannot move.
                 * They can only get energy back by already
                 * being on R, but that reset happens when R
                 * is entered, so we don't allow a move with 0.
                 */
                if (e == 0) {
                    continue;
                }

                int newEnergy = e - 1;
                int newMask = mask;

                char cell = classroom[nr].charAt(nc);

                // Collect litter
                if (cell == 'L') {
                    int id = litterId[nr][nc];
                    newMask |= (1 << id);
                }

                // Reset energy
                if (cell == 'R') {
                    newEnergy = energy;
                }

                int newSteps = steps + 1;

                // All litter collected
                if (newMask == fullMask) {
                    return newSteps;
                }

                /*
                 * Dominance pruning:
                 *
                 * If we have already reached this position with the same collected litter and MORE energy, the current state can be ignored.
                 */
                if (newEnergy <= bestEnergy[nr][nc][newMask]) {
                    continue;
                }

                bestEnergy[nr][nc][newMask] = newEnergy;

                queue.offer(
                    new State(
                        nr,
                        nc,
                        newMask,
                        newEnergy,
                        newSteps
                    )
                );
            }
        }

        return -1;
    }

    static class State {

        int r, c, mask, energy, steps;

        State(int r, int c, int mask, int energy, int steps) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
            this.steps = steps;
        }
    }
}