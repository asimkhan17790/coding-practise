package com.datastructures;

//Singly Linked List another data structure
public class Node {
    public int data;
    public Node next;
    //Next is be default initialized as null
    public Node (int data) {
        this.data = data;
    }

    public static void main(String[] args) {
    
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        head.next = n1;
        head.next.next = n2;

        // traverse list

        Node current = head;
        while (current !=null) {
            System.out.println(current.data);
            current = current.next;
        }

    }
}




