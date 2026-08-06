class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, avg = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
            avg = sum / k;
        }

        int subarrayCount = 0;
        if(avg >= threshold) {
            subarrayCount++;
        }
        
        for(int j = k; j < arr.length; j++) {
            sum = sum - arr[j - k] + arr[j];
            avg = sum / k;

            if(avg >= threshold) {
                subarrayCount++;
            }
        }

        return subarrayCount;
    }
}