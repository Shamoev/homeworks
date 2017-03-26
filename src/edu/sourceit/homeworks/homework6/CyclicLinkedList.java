package edu.sourceit.homeworks.homework6;

import edu.sourceit.homeworks.homework4.queue.Node;

public class CyclicLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.add(new Node(20));
        head.add(new Node(30));
        head.add(new Node(40));
        head.add(new Node(50));
        head.print(head);
        System.out.println();
        Node cyclicNode = new Node(60);
        cyclicNode.setNext(head);
        head.add(cyclicNode);
        // head.print(head);
        //head.add(new Node(100));
        System.out.println(head.isCyclicLinkedList(head));
        System.out.println("The end!");
    }
}
