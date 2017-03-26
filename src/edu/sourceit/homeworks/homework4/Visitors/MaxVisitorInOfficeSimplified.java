package edu.sourceit.homeworks.homework4.Visitors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class MaxVisitorInOfficeSimplified {
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
        int maxVisitorAtOnce = 0;

        // array for all come and leave points
        TimePoint[] timePoints = new TimePoint[visitors.length * 2];

        // Fill array sorting using Insertion Sort
        int j;
        TimePoint key;
        for (int i = 0; i < visitors.length; i++) {
            j = i * 2;
            timePoints[j] = new TimePoint(visitors[i].getComeTime(), true);
            key = timePoints[j];
            while (j > 0 && timePoints[j - 1].getTime() > key.getTime()) {
                j--;
            }
            System.arraycopy(timePoints, j, timePoints, j + 1, (i * 2) - j );
            timePoints[j] = key;

            j = i * 2 + 1;
            timePoints[j] = new TimePoint(visitors[i].getLeaveTime(), false);
            key = timePoints[j];
            while (j > 0 && timePoints[j - 1].getTime() > key.getTime()) {
                j--;
            }
            System.arraycopy(timePoints, j, timePoints, j + 1, (i * 2 + 1) - j );
            timePoints[j] = key;
        }

        int count = 0;
        for (int i = 0; i < timePoints.length; i++) {
            if (timePoints[i].isCome()) {
                count++;
                if (count > maxVisitorAtOnce) {
                    maxVisitorAtOnce = count;
                }
            } else {
                count--;
            }
        }

        System.out.println("Max visitors was " + maxVisitorAtOnce);
    }
}

class TimePoint {
    private long time;
    // true - come; false - leave
    private boolean isCome;

    public boolean isCome() {
        return isCome;
    }

    public long getTime() {
        return time;
    }

    public TimePoint(long time, boolean isCome) {
        this.time = time;
        this.isCome = isCome;
    }
}



