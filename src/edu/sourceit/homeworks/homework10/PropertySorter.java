package edu.sourceit.homeworks.homework10;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PropertySorter {
    private static final String FILE_IN = "D:/projects//SourceIT/homeworks/resources/creditBureau.properties";
    private static final String FILE_OUT = "D:/projects//SourceIT/homeworks/resources/creditBureauSorted.properties";

    public static void main(String[] args) {
        File inputFile = new File(FILE_IN);
        File outputFile = new File(FILE_OUT);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(inputFile);
            List<String> properties = readProperties(input);
            properties.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String s1 = o1.split("=")[0];
                    String s2 = o2.split("=")[0];
                    return s1.compareTo(s2);
                }
            });
            output = new FileOutputStream(outputFile);
            writeProperties(output, properties);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            closeSilently(input, output);
        }
    }

    public static ArrayList<String> readProperties(InputStream input) throws IOException {
        int oneByte;
        ArrayList<String> result = new ArrayList<>();
        StringBuilder property = new StringBuilder();
        while ((oneByte = input.read()) != -1) {
            if (oneByte == '#') {
                while ((oneByte = input.read()) != '\r') {
                }
            }
            if (oneByte == '\r') {
            } else if (oneByte == '\n') {
                if (property.length() != 0) {
                    result.add(property.toString());
                    property.delete(0, property.length());
                }
            } else {
                property.append((char) oneByte);
            }
        }
        return result;
    }

    public static void writeProperties(OutputStream os, List<String> properties) throws IOException {
        int oneByte;
        InputStream is;
        for (int i = 0; i < properties.size(); i++) {
            is = new ByteArrayInputStream(properties.get(i).getBytes());
            while ((oneByte = is.read()) != -1) {
                os.write(oneByte);
            }
            os.write((byte) '\n');
        }
    }

    public static void closeSilently(InputStream is, OutputStream os) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                /*NOP*/
            }
        }
        if (os != null) {
            try {
                os.flush();
            } catch (IOException e) {
                /*NOP*/
            } finally {
                try {
                    os.close();
                } catch (IOException e) {
                    /*NOP*/
                }
            }
        }
    }
}