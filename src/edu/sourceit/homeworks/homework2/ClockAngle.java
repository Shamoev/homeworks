package edu.sourceit.homeworks.homework2;

public class ClockAngle {
    public static void main(String[] args) {
        int hours = 2;
        int mins = 30;
        int result = 0;

        final int DEGREES_IN_BAR = 30;

        // checking input data
        if (hours > 12 || hours < 0 || mins > 60 || mins < 0 || mins % 5 != 0) {
            System.out.println("The input data is wrong!");
            return;
        }

        int minsToHourBars = mins / 5;

        //  calculate angle between hours and minute narrows
        int angleInBars = Math.abs(minsToHourBars - hours);

        // 6 bars = 180 degrees. Calculate angle <= 180
        if (angleInBars > 6)
            angleInBars = 12 - angleInBars;

        result = angleInBars * DEGREES_IN_BAR;

        System.out.println("Angle between hours and minute narrows is " + result);
    }
}
