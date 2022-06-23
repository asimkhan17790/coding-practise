package com.leetcode.linkedLists;

public class LeetCode19RemoveNthNodeFromEndOfList {

      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            ListNode cur=head;

            while(cur!=null){
                System.out.print( " " + cur.val);
                cur=cur.next;
            }

            ListNode result = removeNthFromEnd(head,2);

            System.out.println();

            while(result!=null){
                System.out.print( " " + result.val);
                result=result.next;
            }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // find the length
        if (head==null || head.next==null){
            return null;
        }


        ListNode cur=head;

        int n1=0;
        while(cur!=null){
            n1++;
            cur=cur.next;
        }

        cur=head;

        int k = 0;
        ListNode prev = new ListNode(-1);
        prev.next=head;
        ListNode p2=prev;
        while(cur != null){
            if (n1-k==n){
                prev.next=cur.next;
                break;
            }
            k++;
            prev=cur;
            cur=cur.next;

        }
        return p2.next;

    }

}
