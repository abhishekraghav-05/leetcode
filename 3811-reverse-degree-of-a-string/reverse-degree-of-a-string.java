class Solution {
    public int reverseDegree(String s) {
        int productSum = 0;
        int i = 1;
        for(char ch : s.toCharArray()) {
            int value = 'z' - ch + 1;
            productSum = productSum + (value * i++);
        }

        return productSum;
    }
}