class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;

        int left = 0, right = 0, i = 0;
        int fSum = 0, sSum = 0;
        for(char ch : num.toCharArray()) {
            
            if(i < mid) {
                if(ch == '?') {
                    left++;
                }else {
                    fSum += ch - '0';
                }
                i++;
            }else {
                if(ch == '?') {
                    right++;
                }else {
                    sSum += ch - '0';
                }
            }
        }

        int diff = fSum - sSum;
        int qDiff = left - right;

        if(qDiff % 2 != 0) return true;

        return diff != -9 * (qDiff / 2);
    }
}