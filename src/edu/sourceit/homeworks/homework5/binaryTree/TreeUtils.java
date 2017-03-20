package edu.sourceit.homeworks.homework5.binaryTree;

public class TreeUtils {

    public static int getDepth(BinaryTree tree) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (tree.getLeft() != null) {
            leftDepth = getDepth(tree.getLeft());
        }
        if (tree.getRight() != null) {
            rightDepth = getDepth(tree.getRight());
        }
        return Math.max(leftDepth + 1, rightDepth + 1);
    }

    public static int sumOfAll(BinaryTree tree) {
        int sum = 0;
        if (tree.getLeft() != null) {
            sum += sumOfAll(tree.getLeft());
        }
        if (tree.getRight() != null) {
            sum += sumOfAll(tree.getRight());
        }
        sum += tree.getValue();
        return sum;
    }
}
