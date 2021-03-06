package edu.sourceit.homeworks.homework4;

public class HugeArraySorter {
    public static void main(String[] args) {
        int[] hugeArray = ArrayCreator.createHugeArray(10 );

        int[] counters = new int[10];

        for (int i = 0; i < hugeArray.length; i++) {
            if (hugeArray[i] >= 0 && hugeArray[i] <= 9) {
                counters[hugeArray[i]]++;
            } else {
                System.out.println("The elements are not between [0...9]");
                return;
            }
        }

        long start = System.currentTimeMillis();
        int i = 0;
        for (int j = 0; j < counters.length; j++) {
            for (int k = 0; k < counters[j]; k++) {
                hugeArray[i] = j;
                i++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time with simple paste = " + (end - start));

        /* long start = System.currentTimeMillis();
         int position = 0;
         for (int i = 0; i < counters.length; i++) {
            int[] array = new int[counters[i]];
            Arrays.fill(array, i);
            System.arraycopy(array, 0, hugeArray, position, array.length);
            position += counters[i];
        }
        long end = System.currentTimeMillis();
        System.out.println("Time with fills = " + (end - start));*/

        for (int index = 0; index < hugeArray.length - 1; index++) {
            if (hugeArray[index] > hugeArray[index + 1]) {
                System.out.println("Sort failed!!!");
                return;
            }
        }

        System.out.println("Sort successful!!");
    }
}
