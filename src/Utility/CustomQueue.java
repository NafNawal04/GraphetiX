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
    public boolean addQueue(E value)
    {
        Node<E> newNode = new Node<>(value);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }

        return true;
    }
    public void offer(E item) {
        Node<E> newNode = new Node<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

}
