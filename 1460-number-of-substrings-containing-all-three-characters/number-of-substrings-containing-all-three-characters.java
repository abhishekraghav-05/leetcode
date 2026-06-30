// class Solution {
//     public int numberOfSubstrings(String s) {
//         ArrayList<String> list = new ArrayList<>();
//         return countSubstring("", s, list);
//     }
//     public int countSubstring(String p, String s, ArrayList<String> list) {
//         if(s.isEmpty()) return 0;

//         char ch = s.charAt(0);
//         int count = 0;
//         while(!s.isEmpty()) {
//             list.add(countSubstring(p + ch, s.substring(1)), list);
//             list.add(countSubstring(p, s.substring(1)), list);
//         }

//         for(String str : list) {
//             if(str.contains("abc")) count++;
//         }

//         return count;
//     }
// }

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] last = {-1, -1, -1}; // last seen positions of a, b, c
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i; // update last seen index
            
            if (last[0] != -1 && last[1] != -1 && last[2] != -1) {
                count += 1 + Math.min(last[0], Math.min(last[1], last[2]));
            }
        }
        
        return count;
    }
}
