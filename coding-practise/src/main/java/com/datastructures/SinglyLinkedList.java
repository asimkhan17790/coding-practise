package com.datastructures;

public class SinglyLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        //Next is be default initialized as null
        Node (int data) {
            this.data = data;
        }
    }

    // Insert a node at the end
    public SinglyLinkedList insert(SinglyLinkedList list, int data) {

        Node newNode = new Node (data);
        newNode.next = null;

        if (list.head == null){
            list.head = newNode;
        }else {
            Node lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }

        return list;
    }

    public static void printList(SinglyLinkedList list) {

        Node currentNode = list.head;
        while (currentNode !=null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
    
}
