package edu.sourceit.homeworks.homework4.Visitors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class MaxVisitorInOffice {
    public static void main(String[] args) {
        Visitor[] visitors = Visitor.createVisitors();
        Arrays.sort(visitors, new Comparator<Visitor>() {
            @Override
            public int compare(Visitor o1, Visitor o2) {
                return o1.getComeTime() > o2.getComeTime() ? 1 : -1;
            }
        });
        for (Visitor visitor : visitors) {
            System.out.println("Come  " + new Date(visitor.getComeTime()));
            System.out.println("Leave " + new Date(visitor.getLeaveTime()));
            System.out.println("---");
        }
        // int maxVisitorAtOnce = 0;

        // array for all come and leave points
        long[] pointsOfTime = new long[visitors.length * 2];

        // Fill array sorting using Insertion Sort
        int j;
        long key;
        for (int i = 0; i < visitors.length; i++) {
            key = visitors[i].getComeTime();
            j = i * 2;
            while (j > 0 && pointsOfTime[j - 1] > key ) {
                pointsOfTime[j] = pointsOfTime[j - 1];
                j--;
            }
            pointsOfTime[j] = key;

            key = visitors[i].getLeaveTime();
            j = i * 2 + 1;
            while (j > 0 && pointsOfTime[j - 1] > key ) {
                pointsOfTime[j] = pointsOfTime[j - 1];
                j--;
            }
            pointsOfTime[j] = key;
        }

        // check sorting
        for (int index = 0; index < pointsOfTime.length - 1; index++) {
            if (pointsOfTime[index] > pointsOfTime[index + 1]) {
                System.out.println("Sort failed!!!");
                return;
            }
        }
        System.out.println("Sort successful!!");

        // calculate the number of visitors in the middle points
        long middlePoint;
        int[] visitorsInMiddlePoints = new int[pointsOfTime.length - 1];
        for (int i = 0; i < pointsOfTime.length - 1 ; i++) {
            middlePoint = pointsOfTime[i] + (pointsOfTime[i + 1] - pointsOfTime[i]) / 2;
            for (int k = 0; k < visitors.length; k++) {
                if (middlePoint > visitors[k].getComeTime() && middlePoint < visitors[k].getLeaveTime()) {
                    visitorsInMiddlePoints[i]++;
                }
            }
        }
        // System.out.println(Arrays.toString(visitorsInMiddlePoints));

        // find max visitors
        long maxVisitorsInMiddlePoint = visitorsInMiddlePoints[0];
        for (int i = 0; i < visitorsInMiddlePoints.length; i++) {
            if (visitorsInMiddlePoints[i] > maxVisitorsInMiddlePoint) {
                maxVisitorsInMiddlePoint = visitorsInMiddlePoints[i];
            }
        }

        System.out.println("Max visitors was " + maxVisitorsInMiddlePoint);
    }
}
