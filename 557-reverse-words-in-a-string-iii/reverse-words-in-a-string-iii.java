class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        
        for(int i = 0; i < n; i++) {
            sb.append(new StringBuilder(words[i]).reverse());

            if(i < n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}