class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int num1 = Integer.parseInt(startTime.substring(6,8));
        int num2 = Integer.parseInt(endTime.substring(6,8));

        int ans1 = 0;
        if(num2 < num1) {
            ans1 = (num2 + 60) - num1;
        }else {
            ans1 = num2 - num1;
        }


        int num3 = Integer.parseInt(startTime.substring(3,5));
        int num4 = Integer.parseInt(endTime.substring(3,5));

        int min = 0, ans2 = 0;
        if(num4 < num3) {
            min = (num4 + 60) - num3;
        }else {
            min = num4 - num3;
        }

        if(num2 < num1) {
            ans2 = (min - 1) * 60;
        }else {
            ans2 = min * 60;
        }


        int num5 = Integer.parseInt(startTime.substring(0, 2));
        int num6 = Integer.parseInt(endTime.substring(0, 2));
        int hour = num6 - num5;
        
        int ans3 = 0;
        if(num4 < num3) {
            ans3 = (hour - 1) * 60 * 60;
        }else {
            ans3 = hour * 60 * 60;
        }

        int result = ans1 + ans2 + ans3;

        return result;
    }
}