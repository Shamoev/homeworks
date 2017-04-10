package edu.sourceit.homeworks.homework10;

import java.io.*;
import java.net.URL;
import java.util.zip.GZIPOutputStream;

public class googleReader {
    private static final String URL = "http://google.com";
    // private static final String PATH = "D:\\projects\\SourceIT\\homeworks\\resources\\";
    private static final String PATH = "src/edu/sourceit/homeworks/homework10/";
    private static final String TXT = "google.txt";
    private static final String ZIP = "google.zip";


    public static void main(String[] args) {
        boolean isTxtBroken = false;
        boolean isZipBroken = false;
        InputStream fromUrlIS = null;
        File outTxtFile = new File(PATH + TXT);
        File outZipFile = new File(PATH + ZIP);
        OutputStream toTxtOS = null;
        OutputStream toZipOS = null;
        try {
            fromUrlIS = new URL(URL).openStream();
            try {
                toTxtOS = new FileOutputStream(outTxtFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                toZipOS = new GZIPOutputStream(new FileOutputStream(outZipFile));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if ((toTxtOS == null) && (toZipOS == null)) {
                throw new IOException("Couldn't create or read " + TXT +" and " + ZIP + " files");
            }

            int count;
            byte[] buffer = new byte[10];
            try {
                System.out.println("Writing...");
                while ((count = fromUrlIS.read(buffer)) != -1) {
                    if (toTxtOS != null) {
                        if (!writeWithBuffer(buffer, count, toTxtOS)) {
                            isTxtBroken = true;
                            closeOutputStream(toTxtOS);
                            toTxtOS = null;
                        }
                    }
                    if (toZipOS != null) {
                        if (!writeWithBuffer(buffer, count, toZipOS)) {
                            isZipBroken = true;
                            closeOutputStream(toZipOS);
                            toZipOS = null;
                        }
                    }
                }
                //throw new IOException();
            } catch (IOException e) {
                System.out.println("Couldn't read from url.");
                isTxtBroken = true;
                isZipBroken = true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
        } finally {
            closeOutputStream(toTxtOS);
            closeOutputStream(toZipOS);
            if (isTxtBroken) {
                deleteFile(outTxtFile);
            }
            if (isZipBroken) {
                deleteFile(outZipFile);
            }
            closeInputStream(fromUrlIS);
        }
    }

    public static boolean writeWithBuffer(byte[] buffer, int count, OutputStream os) {
        try {
            os.write(buffer, 0, count);
            // throw new IOException();
            return true;
        } catch (IOException e) {
            System.out.println("Could'n write to file.");
            return false;
        }
    }

    public static void deleteFile(File outFile) {
        try {
            System.out.println("Deleting file: " + outFile.getName());
            outFile.delete();
        } catch (SecurityException e) {
            System.out.println("Couldn't delete file.");
        }
    }

    public static void closeInputStream(InputStream is) {
        if (is != null) {
            try {
                System.out.println("Closing input stream.");
                is.close();
            } catch (IOException e) {
                System.out.println("Couldn't close input stream.");
            }
        }
    }

    public static void closeOutputStream(OutputStream os) {
        if (os != null) {
            try {
                if (os instanceof GZIPOutputStream) {
                    System.out.println("Finishing GZIPOutputStream.");
                    GZIPOutputStream gzipOutputStream = (GZIPOutputStream) os;
                    gzipOutputStream.finish();
                }
                System.out.println("Flushing output stream " + os.getClass().getSimpleName());
                os.flush();
            } catch (IOException e) {
                /*NOP*/
            } finally {
                try {
                    System.out.println("Closing output stream." + os.getClass().getSimpleName());
                    os.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close output stream." + os.getClass().getSimpleName());
                }
            }
        }
    }
}
