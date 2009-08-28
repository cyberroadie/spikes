package net.transformatorhuis.junit.agilejava.ring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Ring<T> implements Iterable<T> {

    private RingNode currentNode = null;
    
    public Ring() {
    }

    public T get() throws EmptyRingNodeException {
        if(currentNode == null) {
            throw new EmptyRingNodeException("Ring is empty");
        }
        return currentNode.getDataElement();
    }

    public void remove() throws EmptyRingNodeException {
        if(currentNode == null) {
            throw new EmptyRingNodeException("Ring is empty");
        }
        RingNode nodeToBeemoved = currentNode;
        currentNode = nodeToBeemoved.getPreviousElement();
        currentNode.setPreviousElement(nodeToBeemoved.getNextElement());
    }

    public void back() {
        currentNode = currentNode.getPreviousElement();
    }

    public void forward() {
        currentNode = currentNode.getNextElement();
    }

    public void add(T data) {
        RingNode ringNode = new RingNode(data);
        if(currentNode != null) {
            ringNode.setPreviousElement(currentNode);
            ringNode.setNextElement(currentNode.nextElement);
            currentNode.setNextElement(ringNode);
            currentNode = ringNode;
        } else {
            currentNode = ringNode;
            currentNode.setNextElement(ringNode);
            currentNode.setPreviousElement(ringNode);
        }
    }

    @Override
    public Iterator<T> iterator() {
        List<T> elementList = new ArrayList<T>();
        elementList.add(currentNode.getDataElement());
        RingNode nextRingNode = currentNode.getNextElement();
        while(nextRingNode != currentNode) {
            elementList.add(nextRingNode.getDataElement());
            nextRingNode = nextRingNode.getNextElement();
        }
        return elementList.iterator();
    }

    private class RingNode {

        private RingNode previousElement = null;
        private RingNode nextElement = null;
        private T dataElement = null;

        public RingNode(T dataElement) {
            this.dataElement = dataElement;
        }

        public T getDataElement() {
            return dataElement;
        }

        public void setDataElement(T dataElement) {
            this.dataElement = dataElement;
        }

        public RingNode getNextElement() {
            return nextElement;
        }

        public void setNextElement(RingNode nextElement) {
            this.nextElement = nextElement;
        }

        public RingNode getPreviousElement() {
            return previousElement;
        }

        public void setPreviousElement(RingNode previousElement) {
            this.previousElement = previousElement;
        }
    }
    
}
