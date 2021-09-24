package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class DequeuePractise {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        System.out.println(deque);
        deque.addFirst(5);
        System.out.println(deque);
        deque.addLast(6);
        System.out.println(deque);
        System.out.println(deque.peekLast());

        // For Stacks
        // push() --> dequeue.addFirst()
        //pop() --> dequeue.removeFirst();

        // For Queue
        // enqueue/add --> dequeue.addfirst()
        // remove/dequeue --> dequeue.removeLast();
    }
    
}
