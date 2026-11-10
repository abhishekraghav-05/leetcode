class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean [][] record = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    record[i][j] = true;
                }else {
                    record[i][j] = false;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(record[i][j]) {
                    for(int x = 0; x < m; x++) {
                        matrix[x][j] = 0;
                    }
                    
                    for(int x = 0; x < n; x++) {
                        matrix[i][x] = 0;
                    }
                }
            }
        }
    }
}