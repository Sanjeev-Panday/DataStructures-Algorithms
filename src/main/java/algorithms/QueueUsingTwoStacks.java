package algorithms;

import datastructures.StackUsingLinkedList;
import datastructures.adt.Queue;
import datastructures.adt.Stack;

public class QueueUsingTwoStacks<Item> implements Queue<Item> {
    private Stack<Item> first;
    private Stack<Item> second;
    public QueueUsingTwoStacks() {
        first = new StackUsingLinkedList<Item>();
        second = new StackUsingLinkedList<Item>();
    }
    @Override
    public void enqueue(Item data) {
        first.push(data);
    }

    @Override
    public Item dequeue() {
        if(!second.isEmpty()) return second.pop();
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        return second.pop();
    }

    @Override
    public boolean isEmpty() {
        return first.isEmpty() && second.isEmpty();
    }

    @Override
    public int size() {
        return first.size() + second.size();
    }
}
