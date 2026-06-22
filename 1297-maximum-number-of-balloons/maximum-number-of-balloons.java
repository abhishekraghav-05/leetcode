class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] freq = new int[26];
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int countB = freq['b' - 'a'] / 1;
        int countA = freq['a' - 'a'] / 1;
        int countL = freq['l' - 'a'] / 2;
        int countO = freq['o' - 'a'] / 2;
        int countN = freq['n' - 'a'] / 1;

        return Math.min(countB, Math.min(countA, Math.min(countL, Math.min(countO, countN))));
    }
}