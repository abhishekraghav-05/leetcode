class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        int i = 0;

        // Match target as much as possible
        while (i < n) {

            int x = target.charAt(i) - 'a';

            if (freq[x] == 0) {
                break;
            }

            ans[i] = target.charAt(i);
            freq[x]--;
            i++;
        }

        // Case 1: target itself can be formed.
        // We need a strictly greater permutation.
        if (i == n) {
            i--;
            freq[target.charAt(i) - 'a']++;
        }

        // Try to increase from the current/rightmost position
        for (int pos = i; pos >= 0; pos--) {

            if (pos < i) {
                freq[target.charAt(pos) - 'a']++;
            }

            int current = target.charAt(pos) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[pos] = (char) ('a' + c);
                    freq[c]--;

                    // Fill suffix with smallest characters
                    int p = pos + 1;

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans[p++] = (char) ('a' + k);
                            freq[k]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}