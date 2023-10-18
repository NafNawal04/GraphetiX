package libraryFunctions;

public class Glist<E> {
    Node<E> head;
    int[] valuearray= new int[1000];


    public void clear() {
        head = null;

    }
    public boolean add(E value) {
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
    public String toString() {
        if (head == null) {
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

    public int length()
    {
        int size=0;
        Node current = head;
        while (current.next != null) {
            size++;
        }
        return size;

    }
    public  void sort()
    {
        Node current = head;
        int n=0;
        while (current.next != null) {
            valuearray[n]= (int) current.data;
            current=current.next;
            n++;
        }
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if ((Integer)valuearray[j] > valuearray[j + 1]) {
                    int temp = valuearray[j];
                    valuearray[j] = valuearray[j + 1];
                    valuearray[j + 1] = temp;
                    swapped = true;
                }
            }


            if (!swapped) {
                break;
            }
        }
    }
}
