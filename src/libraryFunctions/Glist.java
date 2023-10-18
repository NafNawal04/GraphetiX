package libraryFunctions;

public class Glist<E> {
    Node<E> head;

    public void clear() {
        head = null;

    }
    public boolean add(E value) {

        Node<E> current = head;
        while (current.next!=null) {

            current = current.next;
        }

        Node newNode = new Node(value);

        current.next= newNode;
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

        Node current = head;
        while (current.next != null) {
            if (current.next.data==value) {
                return true;
            }
        }

        return false;

    }
    public int length()
    {
        int size=0;
        Node current = head;
        while (current.next != null) {
            size++;
        }
        return size;

    }
}
