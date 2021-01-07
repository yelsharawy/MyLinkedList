public class MyLinkedList {

    private class Node {
        private Node prev = null, next = null;
        private String data;

        private Node(String value) {
            data = value;
        }

        private Node(Node prev, String value) {
            this(value);
            this.prev = prev;
        }

        private Node(Node prev, String value, Node next) {
            this(prev, value);
            this.next = next;
        }

    }

    private Node head = null, tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean add(String value) {
        if (size == 0) {
            head = tail = new Node(value);
        } else {
            tail = tail.next = new Node(tail, value);
        }
        size++;
        return true;
    }

    private Node getNode(int index) {
        if (index < size / 2) {
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        } else {
            Node curr = tail;
            for (int i = size-1; i > index; i--) {
                curr = curr.prev;
            }
            return curr;
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder("[");

        if (size > 0) output.append(head.data);

        for (Node curr = head.next; curr != null; curr = curr.next) {
            output.append(", ").append(curr.data);
        }

        return output.append(']').toString();
    }

}
