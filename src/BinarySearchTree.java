import java.util.Iterator;

public class BinarySearchTree<T extends Comparable> {


    private static class Node<T> {
        T element;
        Node<T> leftChild;
        Node<T> rightChild;
        Node<T> parent;
    }
    private Node<T> root;
    int size;
    public boolean insert(T element){
        final Node<T> newNode = new Node<>();
        newNode.element = element;
        if(isEmpty()) {
            root = newNode;
            size = 1;
            return true;
        } else {
            Node current = root;
            while(!current.element.equals(element) ) {
                if (element.compareTo(current.element) < 0) {
                    if(current.leftChild == null) {
                        current.leftChild = newNode;
                        newNode.parent = current;
                        size++;
                        return true;
                    }
                    current = current.leftChild;
                } else if (element.compareTo(current.element) >= 0) {
                    if(current.rightChild == null) {
                        current.rightChild = newNode;
                        newNode.parent = current;
                        size++;
                        return true;
                    }
                    current = current.rightChild;
                }
            }
            return false; // this indicate we have a duplicate;
        }

    }

    public boolean find(T element){
        Node<T> current = root;
        while(current != null) {
            if(element.compareTo(current.element) == 0){
                return true;
            } else if(element.compareTo(current.element) > 0) {
                current  = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> successor(T element) {
        return new Node<>();
    }
    public void display(Node<T> root){
        Node<T> current = root;
        if(current == null) {
            return;
        }
        display(current.leftChild);
        System.out.print(current.element +" ");
        display(current.rightChild);

    }
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.display(bst.root);
    }
}
