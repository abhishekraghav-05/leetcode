class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m = grid.length;
        int[] arr = new int[m * m];
        int count = 0;
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < m; col++) {
                arr[count] = grid[row][col];
                count++;
            }
        }
        int n = arr.length;
        int i = 0;
        int[] ans = new int[2];
        while(i < n) {
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            }else{
                i++;
            }
        }

        for(int index = 0; index < n; index++) {
            if(arr[index] != index + 1) {
                ans[0] = arr[index];
                ans[1] = index + 1;
                break;
            }
        }

        return ans;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}