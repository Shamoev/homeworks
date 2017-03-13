package edu.sourceit.homeworks.homework3;

public class YourOwnBinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 10, 17, 30, 48};
        int element = 10;
        System.out.println(myOwnBinarySearch(array, element));
    }

    public static int myOwnBinarySearch(int[] array, int element) {
        int indexMin = 0;
        int indexMax = array.length - 1;
        int indexMiddle;
        while (true) {
            if (indexMax < indexMin) {
                return -1;
            }
            indexMiddle = indexMin +(indexMax - indexMin) / 2;
            if (array[indexMiddle] == element) {
                return indexMiddle;
            }
            else if (element > array[indexMiddle]) {
                indexMin = indexMiddle + 1;
            } else {
                indexMax = indexMiddle - 1;
            }
        }
    }
}
