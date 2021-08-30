package com.datastructures;
import java.util.NoSuchElementException;

// Linked List implementation of a Queue
public class MyQueue<T> {

    private static class QueueNode<T> {
        T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;    
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> temp = new QueueNode<T>(item);
        if (last != null){
            last.next = temp;
        }

        last = temp;

        if (first == null) {
            first = last;
        }
        
    }

    public T remove (){
        if (first == null) throw new NoSuchElementException();        
        T item = first.data;
        first = first.next;
        if (first == null) { // if Queue is empty after removing the element???
            last = null;
        }
        return item;
    }

    public T peek(){
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }
    public Boolean isEmpty() {
        return first == null;
    }
}
