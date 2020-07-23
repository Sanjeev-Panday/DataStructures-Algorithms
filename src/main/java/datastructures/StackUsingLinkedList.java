package datastructures;

import datastructures.adt.Stack;

import java.util.Iterator;

public class StackUsingLinkedList<Item> implements Stack<Item> , Iterable<Item> {
    private Node first = null;
    private int size;
    private class Node {
        Node next;
        Item data;
    }

    @Override
    public void push(Item item) {
        Node newNode  = new Node();
        newNode.data = item;
        newNode.next = first;
        first = newNode;
        size++;
    }

    @Override
    public Item pop() {
        Item data = null;
        if(!isEmpty()) {
            data = first.data;
            first = first.next;
            size--;
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current  = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item data = current.data;
            current = current.next;
            return data;
        }
    }
}
