package Utility;

public class CustomLInkedList<E>
{
    Node<E> head;
    Node<E> tail;

    public String toString()
    {
        if (head == null)
        {
            return "Empty List";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public void clear() {
        head = null;

    }

    public boolean addLast(E value) {
        Node<E> newNode = new Node<>(value);

        if (head == null) {

            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        return true;
    }
    public boolean isEmpty()
    {
        return head == null;
    }

    public boolean removeValue(E value) {
        if (head == null) {
            return false;
        }

        if (head.data==value) {
            head = head.next;
            return true;
        }

        Node<E> current = head;
        while (current.next != null) {
            if (current.next.data==value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }
    public boolean remove(int index) {
        if (head == null || index < 0) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            return true;
        }

        Node<E> current = head;
        int currentIndex = 0;
        while (current.next != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current.next == null || current.next.next == null) {
            return false;
        }

        current.next = current.next.next;
        return true;
    }


    public boolean contains(E value)
    {
        if (head == null) {
            return false;
        }

        if (head.data==value) {
            return true;
        }

        Node<E> current = head;
        while (current.next != null) {
            if (current.next.data==value) {
                return true;
            }
            current = current.next;
        }

        return false;

    }

    public int length() {
        int size = 0;
        Node<E> current = head;

        while (current != null) {
            current = current.next;
            size++;
        }

        return size;
    }

    public boolean addFirst(E value)
    {
        Node<E> newNode = new Node<>(value);

        if (head == null) {

            head = newNode;
        } else {

            newNode.next=head;
            head=newNode;
        }

        return true;
    }
    public E get(int index) {
        if (index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        int currentIndex = 0;
        Node<E> current = head;

        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        return current.data;
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

    public E pollQueue()
    {
        if (head == null)
        {
            return null;
        }

        E frontValue = head.data;
        head = head.next;

        if (head == null)
        {
            tail = null;
        }

        return frontValue;
    }




    public void forEach(ElementConsumer<E> consumer)
    {
        Node<E> current = head;
        while (current != null) {
            consumer.accept(current.data);
            current = current.next;
        }
    }


    @FunctionalInterface
    public interface ElementConsumer<E>
    {
        void accept(E element);
    }

        @FunctionalInterface
        public interface Predicate<E> {
            boolean test(E element);
        }

        public boolean anyMatch(Predicate<E> predicate) {
            Node<E> current = head;
            while (current != null) {
                if (predicate.test(current.data)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }


}
