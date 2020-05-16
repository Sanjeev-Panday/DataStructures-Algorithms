import java.util.Iterator;
public class DoublyLinkedList<T> implements Iterable<T>{
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;
        Node(T element){
            this.data = element;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    int size;
    private void init(T element) {
        final Node<T> node = new Node<>(element);
        head = node;
        tail = node;
        size = 1;
    }
    public void addToFront(final T element) {
        if (isEmpty()) {
            init(element);
        } else {
            final Node<T> node = new Node<>(element);
            node.next = head;
            head.prev = node;
            head = node;
            size++;
        }
    }

    public void addToBack(final T element) {
        if(tail!=null) {
            final Node<T> node = new Node<>(element);
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }else
            init(element);

    }

    public void addAtIndex(final T element, final int index) {
        // Boundary condition if index is > size
        if(index >= size) {
            addToBack(element);
            return;
        }
        // Condition to handle if someone tries to add at negative or 0 index
        if(index <= 0){
            addToFront(element);
            return;
        }
        final Node<T> node = new Node<>(element);
        Node<T> current = head;
        int counter = 0;
        while(counter !=index) {
            current = current.next;
            counter++;
        }
        node.next = current;
        node.prev = current.prev;
        current.prev.next = node;
        size++;
    }

    public T deleteFromFront() {
        if(!isEmpty()) {
            T data = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return data;
        }
        return null;
    }

    public T deleteFromEnd(){
        if(!isEmpty()) {
            T data = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return data;
        }
        return null;
    }
    private boolean isEmpty() {
        return size == 0;
    }
    public boolean find(final T element){
        Node<T> current = head;
        while(current!=null) {
            if(current.data == element) {
                return true;
            }
            current  = current.next;
        }
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T element = current.data;
                current = current.next;
                return element;
            }
        };
    }
    public void display(){
        for (T s:this){
            System.out.printf(s+"-->");
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.addToBack("B");
        linkedList.addToBack("C");
        linkedList.addToBack("D");

        linkedList.addToFront("3");
        linkedList.addToFront("2");
        linkedList.addToFront("1");
        linkedList.addAtIndex("F",0);
        linkedList.display();

        System.out.println("Deleted :"+linkedList.deleteFromEnd());
        linkedList.display();

        System.out.println("Deleted :"+linkedList.deleteFromFront());
        linkedList.display();
    }
}
