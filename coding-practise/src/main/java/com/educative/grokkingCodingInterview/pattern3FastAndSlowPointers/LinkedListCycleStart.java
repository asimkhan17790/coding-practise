package com.educative.grokkingCodingInterview.pattern3FastAndSlowPointers;

class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){ // found cycle
                cycleLength = getCycleLength(slow);
                break;
            }
        }
        return findStart(head, cycleLength);
    }
    static ListNode findStart(ListNode head, int cycleLength) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (cycleLength>0){
            p2=p2.next;
            cycleLength--;
        }
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    static int getCycleLength(ListNode head){
        ListNode current = head;
        int length=0;
        do {
            current=current.next;
            length++;
        }while(current!=head);

        return length;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}