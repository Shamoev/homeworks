package edu.sourceit.homeworks.homework7.iterable;


import java.util.Iterator;

public class MyIterableExample {
    public static void main(String[] args) {
        IterableNode head = new IterableNode(5);
        head.setNext(new IterableNode(6));
        head.getNext().setNext(new IterableNode(12));

        for (IterableNode node : head) {
            System.out.print(node.getValue() + "-->");
        }
        System.out.println();

        //
        for (IterableNode node : head) {
            System.out.print(node.getValue() + "-->");
        }
        System.out.println();

        Iterator<IterableNode> iter = head.iterator();
        iter.next();
        iter.next();
        iter.next();
        try {
            iter.next();
        }
        catch (RuntimeException e) {
            System.out.println(e.getClass() + " " +  e.getMessage());
        }

        iter = head.iterator();
        for (IterableNode node : head) {
            System.out.print(node.getValue() + "-->");
        }
    }
}
