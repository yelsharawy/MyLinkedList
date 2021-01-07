public class MyLinkedList {

    private class Node {

        private Node prev = null, next = null;
        private String data;

        private Node(String value) {
            data = value;
        }

        private Node(Node prev, String value) {
            this(value);
            if (prev != null) {
                this.prev = prev;
                prev.next = this;
            }
            if (prev == tail) tail = this;
        }

        private Node(Node prev, String value, Node next) {
            this(prev, value);
            if (next != null) {
                this.next = next;
                next.prev = this;
            }
            if (next == head) head = this;
        }

        public String toString() {
            return "Node("+data+")";
        }

    }

    private Node head = null, tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean add(String value) {
        new Node(tail, value, null);
        size++;
        return true;
    }

    public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("cannot add at index " + index + " for list of size " + size);
        }
        if (index == size) add(value);
        else {
            Node insertBefore = getNode(index);
            new Node(insertBefore.prev, value, insertBefore);
        }
        size++;
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

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("cannot get element at index " + index + " for list of size " + size);
        }
        return getNode(index).data;
    }

    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("cannot set element at index " + index + " for list of size " + size);
        }
        Node node = getNode(index);
        String oldValue = node.data;
        node.data = value;
        return oldValue;
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
