class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int k = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                for(int j = i - 1; j >= k; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                k = i + 1;
            }

            if(i == n - 1) {
                for(int j = i; j >= k; j--) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}