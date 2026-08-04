class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int min = nums[0], max = nums[0];
        for(int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min); 
        }
        for(int i = min + 1; i <= max; i++) {
            boolean found = false;
            for(int num : nums) {
                if(num == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                list.add(i);
            }
        }

        return list;
    }
}