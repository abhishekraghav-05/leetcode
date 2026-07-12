class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums = arr.clone();
        Arrays.sort(nums);

        Map<Integer, Integer> rank = new HashMap<>();
        int currRank = 1;

        for(int num : nums) {
            if(!rank.containsKey(num)) {
                rank.put(num, currRank++);
            }
        }

        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            ans[i] = rank.get(arr[i]);
        }

        return ans;
    }
}