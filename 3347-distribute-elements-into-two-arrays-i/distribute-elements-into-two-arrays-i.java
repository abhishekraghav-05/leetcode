class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        // ArrayList<Integer> arr1 = new ArrayList<>(); 
        // ArrayList<Integer> arr2 = new ArrayList<>();
        int j = 1, k = 1;

        arr1[0] = nums[0];
        arr2[0] = nums[1];
        for(int i = 2; i < n; i++) {
            // if arraylist arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)
            if(arr1[j - 1] > arr2[k - 1]) {   
                arr1[j++] = nums[i];
            }else {
                arr2[k++] = nums[i];
            }
        }

        k = 0;
        for(int i = 0; i < n; i++) {
            if(i < j) {
                nums[i] = arr1[i];
            }else {
                nums[i] = arr2[k++];
            }
        }

        return nums;
    }
}