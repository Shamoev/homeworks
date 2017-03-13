package edu.sourceit.homeworks.homework3;

public class WaterAfterRain {
    public static void main(String[] args) {

        int[] bars = {6, 8, 3, 2, 6, 3, 5, 3, 3};
        // int[] bars = {5, 4, 3, 2, 1, 5, 4, 3, 2, 1};
        // int[] bars = {1, 2, 3, 4, 5};
        // int[] bars = {5, 4, 3, 2, 1};
        // int[] bars = {5, 5, 5, 5, 5};
        // int[] bars = {5, 4, 3, 1, 2, 3, 4, 5};

        // indexes of the elements between which there is water. The goal - to find them
        int startIndex = 0;
        int endIndex = bars.length - 1;

        // loop count
        int i = 0;

        // switchers for conditions
        boolean isStarted = false;
        boolean isEnded = false;

        // index of the element which is less than StartElement but more than all the elements right of it (4 in used bars)
        int maxIndexCrawler = 0;

        while (i < bars.length - 1) {
            // i++ while elements increase
            if (bars[i + 1] >= bars[i] && !isStarted) {
                startIndex = i + 1;
                i++;
                continue;
            }

            // find Start index, initialize maxIndexCrawler
            if (bars[i + 1] < bars[startIndex] && !isStarted) {
                isStarted = true;
                maxIndexCrawler = i + 1;
                System.out.println("Start: [" + startIndex + "] = " + bars[startIndex]);
            }

            // Searching for the EndElement:
            // - less than StartElement but but more than all the elements right of it OR
            // - equal to StartElement OR --> calc
            // - bigger than Start element --> calc
            if (bars[i + 1] < bars[startIndex]){
                if (bars[i + 1] > bars[maxIndexCrawler]) {
                    maxIndexCrawler = i + 1;
                }
                i++;
            } else if (bars[i + 1] == bars[startIndex]) {
                endIndex = i + 1;
                System.out.println("End:   [" + endIndex + "] = " + bars[endIndex]);
                System.out.println("Square is: " + calc(bars, startIndex, endIndex) + "\n");
                // start conditions for the continue search
                i = endIndex;
                startIndex = endIndex;
//                endIndex = bars.length - 1;
                isStarted = false;
                isEnded = true;
            } else {
                    endIndex = i + 1;
                    System.out.println("End:   [" + endIndex + "] = " + bars[endIndex]);
                    System.out.println("square is: " + calc(bars, startIndex, endIndex) + "\n");
                    // start conditions for the continue search
                    i = endIndex;
                    startIndex = endIndex;
//                    endIndex = bars.length - 1;
                    isStarted = false;
                    isEnded = true;
            }

            // boundary condition
            if (maxIndexCrawler == bars.length - 1) {
                isEnded = false;
            }

            // calc if there wasn't (isEnded = false) equal to StartElement or bigger than StartElement in the whole array (i == bars.length - 1) but maxIndexCrawler was found
            // if (maxIndexCrawler == startIndex + 1) there is no water
            if (!isEnded && (i == bars.length - 1) && !(maxIndexCrawler == startIndex + 1)) {
                endIndex = maxIndexCrawler;
                System.out.println("End:   [" + endIndex + "] = " + bars[endIndex]);
                System.out.println("Square is: " + calc(bars, startIndex, endIndex)+ "\n");
                // start conditions for the continue search
                i = maxIndexCrawler;
                startIndex = maxIndexCrawler;
//                endIndex = bars.length - 1;
                isStarted = false;
                isEnded = false;
            }
        }

        System.out.println("\n The end!");
    }

    // calc amount of water called "square"
    public static int calc(int[] bars, int StartIndex, int endIndex) {
        int level = Math.min(bars[StartIndex], bars[endIndex]);
        int sum = 0;
        for (int i = StartIndex + 1; i < endIndex; i++) {
            sum += (level - bars[i]);
        }
        return sum;
    }

}
