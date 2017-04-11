package edu.sourceit.homeworks.homework10;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class PropertySorter {
    private static final String IN_FILE = "D:/projects//SourceIT/homeworks/resources/creditBureau.properties";
    private static final String OUT_FILE = "D:/projects//SourceIT/homeworks/resources/creditBureauSorted.properties";

    public static void main(String[] args) {
        File inputFile = new File(IN_FILE);
        File outputFile = new File(OUT_FILE);

        InputStream input = null;
        try {
            input = new FileInputStream(inputFile);
            System.out.println(ReadProperties(input).toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    /*NOP*/
                }
            }
        }
    }

    public static ArrayList<String> ReadProperties(InputStream input) throws IOException {
        int oneByte;
        ArrayList<String> result = new ArrayList<>();
        StringBuilder property = new StringBuilder();
        while ((oneByte = input.read()) != -1) {
            if (oneByte == '#') {
                while ((oneByte = input.read()) != '\r') {
                }
            }
            if (oneByte == '\r') {
                /*NOP*/
            } else if (oneByte == '\n') {
                if (property.length() != 0) {
                    result.add(property.toString());
                    property = new StringBuilder();
                }
            } else {

                property.append((char) oneByte);
            }
        }
        return result;
    }
}