package edu.sourceit.homeworks.homework4.queue;

public class Node {
    private int value;
     protected Node next;

    public Node(int value) {
        this.value =value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void add(Node node) {
        Node last = this;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(node);
    }

    public void removeLast() {
        Node last = this;
        if (last.getNext() == null) {
            System.out.println("You can't delete head!");
            return;
        }
        while (last.getNext().getNext() != null) {
            last = last.getNext();
        }
        last.setNext(null);
    }

    public void print(Node head) {
        System.out.print(head.getValue() + " --> ");
        if (head.getNext() != null) {
            print(head.getNext());
        }
        // System.out.println();
    }

    /**
     * Removes Node from list that is located on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     **/
    public void remove(int position) {
        if (position == 0) {
            System.out.println("You can't delete head!");
            return;
        }
        Node crawler = this;
        for (int i = 0; i < position - 1; i++) {
            if (crawler.getNext() == null || crawler.getNext().getNext() == null){
                System.out.println("There is no such position to delete!");
                return;
            }
            crawler = crawler.getNext();
        }
        crawler.setNext(crawler.getNext().getNext());
    }

    /**
     * Adds Node to list on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     * @param node node should be inserted at position
     */
    public void addNode(int position, Node node) {
        Node crawler = this;
        for (int i = 0; i < position; i++) {
            if (crawler.getNext() == null){
                System.out.println("There is no such position to add after!");
                return;
            }
            crawler = crawler.getNext();
        }
        node.setNext(crawler.getNext());
        crawler.setNext(node);
    }

    /**
     * Gets the Node that located on the position starting from the tail (end of the list)
     * if position is more than list size - prints error message
     * @param position number of the Node starting from the tail
     * @return Node that located on the position from the tail (end of list) if position exists in list
     */
    public Node getFromTail(int position) {
        int numberOfEl = this.getSize();
        if (position > numberOfEl || position <= 0) {
            System.out.println("The position is illegal.");
            return null;
        }
        Node crawler = this;
        for (int i = 0; i < numberOfEl - position; i++) {
            crawler = crawler.getNext();
        }
        return crawler;
    }

    public Node getFromTailWithoutGetSize(int position) {
        if (position < 1) {
            System.out.println("The position is illegal.");
            return null;
        }
        Node[] nodes = new Node[position];
        Node crawler = this;
        int count = 0;
        while (crawler.getNext() != null) {
            crawler = crawler.getNext();
            System.arraycopy(nodes, 0, nodes,1, nodes.length - 1);
            nodes[0] = crawler;
            count++;
        }
        if (count >= position) {
            return nodes[position - 1];
        } else if (count == position - 1) {
            return this;
        } else {
            System.out.println("The list's length is less than position");
            return null;
        }
    }

    public Node getFromTailWithAnchor(int position) {
        if (position < 1) {
            System.out.println("The position is illegal.");
            return null;
        }
        Node crawler = this;
        Node anchor = this;
        for (int i = 1; i < position; i++) {
            if (crawler.getNext() == null) {
                System.out.println("The list's length is less than position");
                return null;
            }
            crawler = crawler.getNext();
        }

        while (crawler.getNext() != null) {
            crawler = crawler.getNext();
            anchor = anchor.getNext();
        }
        return anchor;
    }

    /**
     * Returns the number of elements of the linked list
     * @return The number of elements of the linked list
     */
    public int getSize() {
        Node crawlrer = this;
        int count = 1;
        while (crawlrer.getNext() != null) {
            crawlrer = crawlrer.getNext();
            count++;
        }
        return count;
    }

    public  boolean isCyclicLinkedList(Node head){
        Node crawler = head;
        while(crawler.getNext() != null){
            Node cyclicNode = head;
            do {
                if (cyclicNode == crawler.getNext())
                    return true;
                cyclicNode = cyclicNode.getNext();
            }
            while (cyclicNode != crawler.getNext());
            crawler = crawler.getNext();
        }
        return false;
    }
}
