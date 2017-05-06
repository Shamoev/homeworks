package edu.sourceit.homeworks.homework11;

import java.util.Arrays;
import java.util.Random;

public class MultiThreadingArrayMergeSorter {
    public static final int PARTS = 5;
    public static void main(String[] args) {
        int[] array = createArray();
        int[] partOfArray;
        int partSize = array.length / PARTS;// = array.length / PARTS;
        int[][] partsOfArray = new int[PARTS][];
        MergeSorterRunnable sorter;
        MergeSorterRunnable[] sorters = new MergeSorterRunnable[PARTS];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < PARTS; i++) {
            if (i != PARTS - 1) {
                partOfArray = new int[partSize];
                System.arraycopy(array, partSize * i, partOfArray, 0, partSize);
            } else{
                partSize = array.length - i * partSize;
                partOfArray = new int[partSize];
                System.arraycopy(array, array.length - partSize, partOfArray, 0, partSize);
            }
            sorter = new MergeSorterRunnable(partOfArray, partsOfArray, i);
            sorters[i] = sorter;
            new Thread(sorter).start();
        }

        while (true) {
            boolean finished = true;
            for (int i = 0; i < sorters.length; i++) {
                if (!sorters[i].isFinished()) {
                    finished = false;
                }
            }
            if (finished) {
                break;
            }
        }

        int[] resultWithThreads = partsOfArray[0];
        for (int i = 1; i < PARTS; i++) {
            resultWithThreads = mergeArrays(resultWithThreads, partsOfArray[i]);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Merge sort with threads took " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        int[] resultWithoutThreads = mergeSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Merge sort took " + (endTime - startTime) + " ms");
    }

    public static int[] mergeSort(int[] array) {
        return doMergeSort(
                Arrays.copyOfRange(array, 0, array.length / 2),
                Arrays.copyOfRange(array, array.length / 2, array.length));
    }

    public static int[] doMergeSort(int[] left, int[] right) {
        if (left.length > 1) {
            left = doMergeSort(Arrays.copyOfRange(left, 0, left.length / 2),
                    Arrays.copyOfRange(left, left.length / 2, left.length));
        }
        if (right.length > 1) {
            right = doMergeSort(Arrays.copyOfRange(right, 0, right.length / 2),
                    Arrays.copyOfRange(right, right.length / 2, right.length));
        }
        return mergeArrays(left, right);
    }

    public static int[] mergeArrays(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int index = 0; index < result.length; index++) {
            if (leftIndex > left.length - 1) {
                System.arraycopy(right, rightIndex, result, index, result.length - index);
                break; //for
            }
            if (rightIndex > right.length - 1) {
                System.arraycopy(left, leftIndex, result, index, result.length - index);
                break; //for
            }
            if (left[leftIndex] > right[rightIndex]) {
                result[index] = right[rightIndex++];
            } else {
                result[index] = left[leftIndex++];
            }
        }
        return result;
    }

    private static int[] createArray() {
        Random random = new Random();
        int[] result = new int[10_000_000];
        for (int index = 0; index < result.length; index++) {
            result[index] = random.nextInt(1000);
        }
        return result;
    }

    static class MergeSorterRunnable implements Runnable {
        private int[] inputArray;
        private int[][] outputArray;
        private int index;
        private boolean finished;
        public boolean isFinished() {
            return finished;
        }

        public MergeSorterRunnable(int[] inputArray, int[][] outputArray, int index) {
            this.inputArray = inputArray;
            this.outputArray = outputArray;
            this.index = index;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            outputArray[index] = mergeSort(inputArray);
            finished = true;
        }
    }
}
