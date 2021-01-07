public class MyLinkedList {

    private class Node {
        private Node prev = null, next = null;
        private String data;
    }

    private Node head = null, tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

}
