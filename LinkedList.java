public class LinkedList<T> {
    public enum ListType {SINGLY, DOUBLY, CIRCULAR}

    private Node<T> head;
    private Node<T> tail;
    private ListType type;

    public LinkedList(ListType type) {
        this.type = type;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
            if (type == ListType.CIRCULAR) {
                tail.next = head;
            }
            return;
        }
        tail.next = newNode;
        if (type != ListType.SINGLY) {
            newNode.prev = tail;
        }
        tail = newNode;
        if (type == ListType.CIRCULAR) {
            tail.next = head;
        }
    }

    public boolean delete(T data) {
        if (head == null) return false;
        Node<T> current = head;
        Node<T> previous = null;
        do {
            if (current.data.equals(data)) {
                if (current == head) {
                    head = head.next;
                    if (type != ListType.SINGLY && head != null) {
                        head.prev = null;
                    }
                    if (type == ListType.CIRCULAR && tail != null) {
                        tail.next = head;
                    }
                } else {
                    previous.next = current.next;
                    if (type != ListType.SINGLY && current.next != null) {
                        current.next.prev = previous;
                    }
                    if (current == tail) {
                        tail = previous;
                        if (type == ListType.CIRCULAR) {
                            tail.next = head;
                        }
                    }
                }
                if (head == null) {
                    tail = null;
                }
                return true;
            }
            previous = current;
            current = current.next;
        } while (current != null && (type != ListType.CIRCULAR || current != head));
        return false;
    }

    public boolean search(T data) {
        if (head == null) return false;
        Node<T> current = head;
        do {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        } while (current != null && (type != ListType.CIRCULAR || current != head));
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("Lista vacía");
            return;
        }
        Node<T> current = head;
        do {
            System.out.println(current.data);
            current = current.next;
        } while (current != null && (type != ListType.CIRCULAR || current != head));
    }

    public Node<T> getHead() {
        return head;
    }
}
