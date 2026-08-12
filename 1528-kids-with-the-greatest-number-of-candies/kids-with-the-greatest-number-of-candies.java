class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxCandies = 0;
        
        for(int num : candies) {
            maxCandies = Math.max(maxCandies, num);
        }

        for(int i = 0; i < candies.length; i++) {
            int addCandies = candies[i] + extraCandies;

            if(maxCandies <= addCandies) {
                list.add(true);
            }else {
                list.add(false);
            }
        }

        return list;
    }
}