package hash.table;

/**
 * Created by sjoshua270 on 10/23/2014.
 */
public class LinkedList implements List {

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean add(int key, String newItem) {
        if (head == null) {
            head = new Node(key, newItem);
            size++;
            return true;
        }
        Node temp = new Node(key, newItem);
        temp.setNext(head);
        head = temp;
        size++;
        return true;
    }

    public String get(int key) {
        Node current = head;
        while (current != null && current.getKey() != key)
            current = current.getNext();
        return (String) current.getContent();
    }

    public String remove(int key) {
        Node current, previous;
        current = head;
        previous = null;
        while (current != null && current.getKey() != key) {
            previous = current;
            current = current.getNext();
        }
        String output = current.getContent();
        if (previous == null) {
            head = head.getNext();
            size--;
            return output;
        }
        previous.setNext(current.getNext());
        size--;
        return output;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if(isEmpty()) return null;
        Node current = head;
        String output = "";
        while (current != null) {
            output += current.getContent();
            if (current.getNext() != null)
                output += ", ";
            current = current.getNext();
        }
        return output;
    }

}
