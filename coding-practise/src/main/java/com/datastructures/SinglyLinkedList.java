package com.datastructures;

public class SinglyLinkedList {

    public Node head;

    public static class Node {
        public int data;
        public Node next;

        //Next is be default initialized as null
        public Node (int data) {
            this.data = data;
        }
    }

    // Insert a node at the end
    public static SinglyLinkedList insert(SinglyLinkedList list, int data) {

        Node newNode = new Node (data);
        newNode.next = null;

        if (list.head == null){
            list.head = newNode;
        }else {
            Node lastNode = list.head;
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

    public static SinglyLinkedList deleteNode (SinglyLinkedList list, int d) {

        Node currentNode = list.head;
        if (currentNode.data == d) {
            list.head = currentNode.next;
            return list;            
        }
        while (currentNode.next!=null) {
                if (currentNode.next.data == d) {
                    currentNode.next = currentNode.next.next;
                }
                currentNode = currentNode.next;
        }

        return list;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
   
        //
        // ******INSERTION******
        //
   
        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        
        //printList(list);
        deleteNode(list, 7);
        printList(list);
        deleteNode(list, 6);
        printList(list);
    }
    
}
