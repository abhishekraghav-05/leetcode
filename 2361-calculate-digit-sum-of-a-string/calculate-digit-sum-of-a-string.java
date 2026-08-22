class Solution {
    public String digitSum(String s, int k) {
        
        while(k < s.length()) {
            int n = s.length();
            int kVal = k;
            int sum = 0;
            String str = "";

            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(kVal > 0) {
                    sum += ch - '0';
                    kVal--;
                }

                if(kVal == 0 || i == n - 1) {
                    str += sum;
                    sum = 0;
                    kVal = k;
                }
            }

            s = str;
        }

        return s;
    }
}