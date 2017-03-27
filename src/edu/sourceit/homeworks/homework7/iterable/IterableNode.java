package edu.sourceit.homeworks.homework7.iterable;

import edu.sourceit.homeworks.homework4.queue.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableNode extends Node implements Iterable<IterableNode> {


    public IterableNode(int value) {
        super(value);
    }

    @Override
    public IterableNode getNext() {
        return (IterableNode)next;
    }

    @Override
    public Iterator iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator {
        // Should I place these instance fields there, so after calling this.iterator
        // I have new instance of NodeIterator with start position every time of calling,
        // or it's better to place them to IterableNode and initialize with IterableNode constructor once?
        IterableNode iterableNodeToPutOutNext;
        IterableNode iterableNodeToPutOut;

        public NodeIterator() {
            this.iterableNodeToPutOutNext = IterableNode.this;
            this.iterableNodeToPutOut = IterableNode.this;
        }

        @Override
        public boolean hasNext() {
            // Should this method return to the start position after reaching the end of the List?
            if (iterableNodeToPutOut.getNext() != null) {
                return true;
            } else {
                iterableNodeToPutOutNext = IterableNode.this;
                iterableNodeToPutOut = IterableNode.this;
                return false;
            }
        }

        @Override
        public IterableNode next() {
            try {
                iterableNodeToPutOut = iterableNodeToPutOutNext;
                iterableNodeToPutOutNext = iterableNodeToPutOutNext.getNext();
                return iterableNodeToPutOut;
            } catch (Throwable e) {
                throw new NoSuchElementException("Failed because: " + e.getClass().getSimpleName());
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
