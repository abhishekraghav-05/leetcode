class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> see = new HashSet<>();
        for(int num:nums){
            if(see.contains(num)){
                return true;
            }
            see.add(num);
        }
        return false;
    }
}