package edu.sourceit.homeworks.homework4.queue;

public class NodeTest {
    public static void main(String[] args) {
        Node head = new Node(1);

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
        Node node = head.getFromTailWithoutGetSize(position);
        if (node != null) {
            System.out.println("The element on the " + position + " position from the tail is : " + node.getValue());
        }

        position = 1;
        Node head2 = new Node(2);
        head2.print(head2);
        System.out.println();
        node = head2.getFromTailWithoutGetSize(position);
        if (node != null) {
            System.out.println("The element on the " + position + " position from the tail is : " + node.getValue());
        }
    }

}
