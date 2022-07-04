package com.educative.grokkingCodingInterview.pattern3FastAndSlowPointers;


class LinkedListCycle {
    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle.ListNode head = new LinkedListCycle.ListNode(1);
        head.next = new LinkedListCycle.ListNode(2);
        head.next.next = new LinkedListCycle.ListNode(3);
        head.next.next.next = new LinkedListCycle.ListNode(4);
        head.next.next.next.next = new LinkedListCycle.ListNode(5);
        head.next.next.next.next.next = new LinkedListCycle.ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }
}