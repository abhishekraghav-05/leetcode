class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        // Count characters
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check whether s can form a palindrome
        int odd = 0;
        int middle = -1;

        for (int c = 0; c < 26; c++) {
            if (freq[c] % 2 == 1) {
                odd++;
                middle = c;
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;

        // Frequency available for the left half
        int[] halfFreq = new int[26];

        for (int c = 0; c < 26; c++) {
            halfFreq[c] = freq[c] / 2;
        }

    
        char[] left = new char[halfLen];

        int pos = 0;

        while (pos < halfLen) {

            int c = target.charAt(pos) - 'a';

            if (halfFreq[c] == 0) {
                break;
            }

            left[pos] = (char) ('a' + c);
            halfFreq[c]--;
            pos++;
        }

    
        if (pos == halfLen) {

            String candidate = build(left, middle);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        
        for (int pivot = halfLen - 1; pivot >= 0; pivot--) {

            int[] available = new int[26];

            for (int c = 0; c < 26; c++) {
                available[c] = freq[c] / 2;
            }

            // Make positions [0 ... pivot-1] equal to target
            boolean possible = true;

            for (int j = 0; j < pivot; j++) {

                int c = target.charAt(j) - 'a';

                if (available[c] == 0) {
                    possible = false;
                    break;
                }

                available[c]--;
            }

            if (!possible) {
                continue;
            }

            int targetChar = target.charAt(pivot) - 'a';

            
            for (int c = targetChar + 1; c < 26; c++) {

                if (available[c] == 0) {
                    continue;
                }

                char[] result = new char[halfLen];

                // Copy target prefix
                for (int j = 0; j < pivot; j++) {
                    result[j] = target.charAt(j);
                }

                // Make this position greater
                result[pivot] = (char) ('a' + c);
                available[c]--;

                // Fill remaining positions as small as possible
                int index = pivot + 1;

                for (int x = 0; x < 26; x++) {

                    while (available[x] > 0) {
                        result[index++] = (char) ('a' + x);
                        available[x]--;
                    }
                }

                return build(result, middle);
            }
        }

        return "";
    }

    private String build(char[] left, int middle) {

        StringBuilder sb = new StringBuilder();

        // Left half
        for (char ch : left) {
            sb.append(ch);
        }

        // Middle character for odd length
        if (middle != -1) {
            sb.append((char) ('a' + middle));
        }

        // Right half
        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}