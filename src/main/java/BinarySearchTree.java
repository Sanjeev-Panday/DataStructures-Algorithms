public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class Node<T> {
        T element;
        Node<T> leftChild;
        Node<T> rightChild;
        Node<T> parent;
    }
    private Node<T> root;
    private int size;
    public void insert(T element){
        final Node<T> newNode = new Node<>();
        newNode.element = element;
        if(isEmpty()) {
            root = newNode;
            size = 1;
        } else {
            Node<T> current = root;
            while(!current.element.equals(element) ) {
                if (element.compareTo(current.element) < 0) {
                    if(null == current.leftChild) {
                        current.leftChild = newNode;
                        newNode.parent = current;
                        size++;
                        return;
                    }
                    current = current.leftChild;
                } else if (element.compareTo(current.element) >= 0) {
                    if(null == current.rightChild) {
                        current.rightChild = newNode;
                        newNode.parent = current;
                        size++;
                        return;
                    }
                    current = current.rightChild;
                }
            }
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

    /**
     *
     * <div>
     *     <b> THis method will find the successor for the given element</b>
     *     <p>
     *         Algorithm is :
     *         <ul>
     *             <li> Find the element</li>
     *             <li> If given element has a right child Then
     *                  <ul>
     *                      <li> Successor = left most child of the right child</li>
     *                  </ul>
     *             </li>
     *             <li>
     *                 Else - traverse up the tree util you find a node who is left child of it's parent
     *                 That node will be the successor;
     *
     *             </li>
     *         </ul>
     *     </p>
     * </div>
     *
     *
     * @param element
     * @return Null value represents absence of successor
     */
    public T successor(T element) {
        Node<T> current = root;
        while(current !=null && !element.equals(current.element)) {
            if(element.compareTo(current.element) > 0) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        // The given element is not present in the tree
        if(current == null) {
            return null;
        }
        // The element has a right child;
        if(current.rightChild != null){
            Node<T> successor = current.rightChild;
            while(successor.leftChild != null) {
                successor = successor.leftChild;
            }
            return successor.element;
        } else {
            Node<T> temp = current.parent;

            while ( temp!=null ) {
                if(temp == temp.parent.leftChild) {
                    return temp.parent.element;
                }
                temp = temp.parent;
            }
            return null;
        }


    }
   
    /* This methods display Binary Search Tree elments in sorted order */
    public void display(BinarySearchTree<T> bst){
        inOrderDisplay(bst.root);
    }
    private void inOrderDisplay(Node<T> node) {
        Node<T> current = node;
        if(current == null) {
            return;
        }
        inOrderDisplay(current.leftChild);
        System.out.print(current.element +" ");
        inOrderDisplay(current.rightChild);
    }
}
