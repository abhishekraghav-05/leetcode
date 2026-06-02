class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinish = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                // Plan A: land → water
                int finishLand = landStartTime[i] + landDuration[i];
                int startWater = Math.max(finishLand, waterStartTime[j]);
                int finishA = startWater + waterDuration[j];
                minFinish = Math.min(minFinish, finishA);

                // Plan B: water → land
                int finishWater = waterStartTime[j] + waterDuration[j];
                int startLand = Math.max(finishWater, landStartTime[i]);
                int finishB = startLand + landDuration[i];
                minFinish = Math.min(minFinish, finishB);
            }
        }

        return minFinish;
    }
}