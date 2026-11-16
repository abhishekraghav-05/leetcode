class Solution {
    public String digitSum(String s, int k) {
        
        while(k < s.length()) {
            StringBuffer sb = new StringBuffer();

            int n = s.length();
            int kVal = k;
            int sum = 0;

            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(kVal > 0) {
                    sum += ch - '0';
                    kVal--;
                }

                if(kVal == 0 || i == n - 1) {
                    sb.append(sum);
                    sum = 0;
                    kVal = k;
                }
            }

            s = sb.toString();
        }

        return s;
    }
}