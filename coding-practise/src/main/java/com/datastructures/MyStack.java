package com.datastructures;

import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
// Implementation  of Stack Data structure using a LinkedList
public class MyStack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;


    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }
    
    public void push (T item) {

        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public Boolean isEmpty() {
        Deque d = new LinkedList<>();
        
        
        return top == null;

    }
}
