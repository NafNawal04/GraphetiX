package Utility;

public class CustomQueue<E> {
    private Node<E> head;  // front of the queue
    private Node<E> tail;  // rear of the queue

    public boolean isEmpty() {
        return head == null;
    }

    public CustomQueue() {
        this.head = null;
        this.tail = null;
    }

}
