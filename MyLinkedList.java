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

}
