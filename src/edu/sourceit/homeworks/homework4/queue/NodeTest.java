package edu.sourceit.homeworks.homework4.queue;

public class NodeTest {
    public static void main(String[] args) {
        Node head = new Node(1);
        // head.remove(3);

        head.add(new Node(2));
        head.add(new Node(3));
        head.add(new Node(4));
        head.add(new Node(5));

        head.print(head);
        System.out.println();

        head.removeLast();
        head.print(head);
        System.out.println();

        head.addNode(1, new Node(10));
        head.print(head);
        System.out.println();

        head.addNode(5, new Node(25));
        head.addNode(4, new Node(25));
        head.print(head);
        System.out.println();

        head.remove(2);
        head.print(head);
        System.out.println();

        head.add(new Node(10));
        head.add(new Node(20));
        head.add(new Node(30));
        head.print(head);
        System.out.println();

        System.out.println("The number of elements is : " + head.getSize());
        int position = 8;
       /* if (head.getFromTail(position) != null) {
            System.out.println("The element on the " + position + " position from the tail is : " + head.getFromTail(position).getValue());
        }*/

        head.getFromTailWithoutGetSize(position);
    }

}
