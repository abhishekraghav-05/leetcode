class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxLight = 0;
        for(int light : lights) {
            maxLight = Math.max(maxLight, light);
        }

        int maxPossible = 0;
        for(int i = 0; i < arrivalTime.length; i++) {
            int r = arrivalTime[i] % period;
        
            int waitTime;
            if(r >= maxLight) {
                waitTime = period - r;
            }else {
                waitTime = 0;
            }

            maxPossible = Math.max(maxPossible, waitTime);
        }

        return maxPossible;
    }
}