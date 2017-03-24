package edu.sourceit.homeworks.homework4.Visitors;

/**
 * Created by Администратор on 24.03.2017.
 */
public class TimePoint {
    private long time;
    // true - come; false - leave
    private boolean type;

    public boolean isType() {
        return type;
    }

    public long getTime() {
        return time;
    }

     public TimePoint(long time, boolean type) {
        this.time = time;
        this.type = type;
     }
}

