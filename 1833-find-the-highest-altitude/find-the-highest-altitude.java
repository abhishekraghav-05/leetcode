class Solution {
    public int largestAltitude(int[] gain) {
        int netGain = 0;
        int maxGain = 0;

        for(int i = 0; i < gain.length; i++) {
            netGain += gain[i];
            maxGain = Math.max(netGain, maxGain);
        }

        return maxGain;
    }
}