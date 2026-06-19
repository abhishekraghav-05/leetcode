class Solution {
    public int largestAltitude(int[] gain) {
        
        int altitudeGain = 0, maxGain = Integer.MIN_VALUE;
        for(int num : gain) {
            altitudeGain += num;
            maxGain = Math.max(maxGain, altitudeGain);
        }

        if(maxGain < 0) return 0;
        return maxGain;
    }
}