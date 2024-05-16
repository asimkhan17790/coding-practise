package com.datastructures.lists;


/*
*
*
*
*  1-3-4-5-7-6-41-9  --> 1-9-3-41-4-6-5-7
*  1-2-3-4-5-6-7 --> 1-7-2-6-3-5
*
*
* */
public class RearrangeLinkedlists {

    static class Node {
         int value;
         Node next;

        public Node(int value){
            this.value = value;
            this.next=null;
        }
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private static Node rearrangeList(Node head) {
        Node middle = findMiddle(head);
        Node t = middle.next;
        middle.next=null;
        Node head2 = reverseLinkedList(t);
        Node result = new Node(-99);
        Node cur1 = head;
        Node cur2= head2;
        Node temp = result;
        while (cur2 != null ||  cur1 != null){
            if (cur1 != null) {
                temp.next=cur1;
                temp = temp.next;
                cur1 = cur1.next;
            }
            if(cur2!=null){
                temp.next = cur2;
                temp = temp.next;
                cur2=cur2.next;
            }
        }
        return result.next;
    }

    private static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast!=null  && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 ---> 1-6-2-5-3-4
    //
    private static Node reverseLinkedList(Node head) {
        Node current = head;
        Node prev = null;

        while (current != null){ //1
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }

    static void printLinkedlist(Node head){
        Node cur = head;
        while (cur!=null){
            System.out.print(cur.value + "  ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        //head.next.next.next.next.next = new Node(6);
        printLinkedlist(rearrangeList(head));

    }
}
