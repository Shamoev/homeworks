package edu.sourceit.homeworks.homework2;

public class ClockAngle {
    public static void main(String[] args) {
        int hours = 2;
        int mins = 30;
        final int  MINS_IN_HOUR_BAR = 5;
        final int DEGREES_IN_MNUTE = 6;

        // checking input data
        if (hours > 12 || hours < 0 || mins > 60 || mins < 0) {
            System.out.println("The input data is wrong!");
            return;
        }

        int angle = Math.abs(mins - hours * MINS_IN_HOUR_BAR) * DEGREES_IN_MNUTE;

        if (angle > 180)
            angle = 360 - angle;

        System.out.println("Angle between hours and minute narrows is " + angle);
    }
}
