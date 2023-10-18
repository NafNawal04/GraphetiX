package libraryFunctions;

public class Glist <E> {
    Node<E> head;

    int[] valuearray= new int[1000];



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
    public  boolean isEmpty()
    {
        if(head==null)
            return true;
        else
            return false;
    }

    public boolean removeValue(E value) {
        if (head == null) {
            return false;
        }

        if (head.data==value) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data==value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
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
    public int Length()
    {
        int size=0;
        Node current = head;
        while (current.next != null) {
            size++;
        }
        return size;

    }
    public void sort() {

        if (valuearray == null) {
            System.out.println("Glist is Empty");
        }


        Node current = head;
        int n = 0;
        while (current != null) {
            valuearray[n] = (int) current.data;
            current = current.next;
            n++;
        }
        int temp ;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (valuearray[i] > valuearray[j]) {
                    temp = valuearray[i];
                    valuearray[i] = valuearray[j];
                    valuearray[j] = temp;
                }
            }


        }
    }





}