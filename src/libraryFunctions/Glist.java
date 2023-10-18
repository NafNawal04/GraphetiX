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
}
