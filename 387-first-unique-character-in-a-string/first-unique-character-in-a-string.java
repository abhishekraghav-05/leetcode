class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        // To count frequency of each character
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // To check which unique character comes first
        for(int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}