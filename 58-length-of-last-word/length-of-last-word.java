class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0, lastCount = 0;

        for(char c : s.toCharArray()) {
            if(c == ' ') {
                count = 0;
            }else {
                count++;
                lastCount = count;
            }
        }

        if(count == 0) return lastCount;

        return count;
    }
}