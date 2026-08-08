class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int kRange = 2 * k + 1;
        int[] arr = new int[n];
        long sum = 0;

        for(int j = 0; j < n; j++) {  //in placeof loop we use"java.util.Arrays.fill(arr, -1);"
            arr[j] = -1;        
        }

        if(kRange > n) return arr;

        for(int i = 0; i < kRange; i++) {
            sum += nums[i];
        }
        
        int mid = (kRange / 2);
        arr[mid++] = (int)(sum / kRange);

        for(int i = kRange; i < n; i++) {
            sum = sum - nums[i - kRange] + nums[i]; 
            arr[mid++] =(int)(sum / kRange);
        }

        return arr;
    }
}