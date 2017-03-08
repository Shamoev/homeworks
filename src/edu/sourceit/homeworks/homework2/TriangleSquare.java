package edu.sourceit.homeworks.homework2;

public class TriangleSquare {
    public static void main(String[] args) {
        int x1 = 1, y1 = 1;
        int x2 = 10, y2 = 7;
        int x3 = -3, y3 = 4;
        double length = 0;
        double square = 0;

        // calculane lengths of sides
        double[] sides = {
                Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)),
                Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1)),
                Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3))
        };

        // find maxSide and its index
        double maxSide = sides[0];
        int indexOfMaxSide = 0;
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] > maxSide) {
                maxSide = sides[i];
                indexOfMaxSide = i;
            }
        }

        // calculate sum of other 2 sides
        double sumOfOtherTwoSides = 0;
        for (int i = 0; i < sides.length ; i++) {
            if (i != indexOfMaxSide)
                sumOfOtherTwoSides += sides[i];
        }

        // calculate length an square (Geron's formula)
        if (maxSide == sumOfOtherTwoSides) {
            length = maxSide;
            square = 0;
        } else {
            length = sides[0] + sides[1] + sides[2];
            square = Math.sqrt((length / 2) * (length / 2 - sides[0]) * (length / 2 - sides[1]) * (length / 2 - sides[2]));
        }
        System.out.println("Length of all sides is " + length);
        System.out.println("Square is " + square);
    }
}
