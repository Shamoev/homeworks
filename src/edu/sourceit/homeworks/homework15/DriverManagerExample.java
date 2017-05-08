package edu.sourceit.homeworks.homework15;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DriverManagerExample {
    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        //Driver driver = (Driver) forName("com.mysql.jdbc.Driver").newInstance(); before 1.7
        /*DriverManager.registerDriver(driver);*/
        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement());
        }
    }
}
