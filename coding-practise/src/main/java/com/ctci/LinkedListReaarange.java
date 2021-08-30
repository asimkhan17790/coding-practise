package com.ctci;

import com.datastructures.SinglyLinkedList;



/**
 * 
 * Given an even length linked list 1,2,3,4,100,101,102,103 -< rearrange the list like => 1,101,2,202,3,303,4,404
 * CTCI Page 93 - Runner Technique
 */
public class LinkedListReaarange {

    public static void main(String[] args) {
        
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList.insert(list, 1);
        SinglyLinkedList.insert(list, 2);
        SinglyLinkedList.insert(list, 3);
        SinglyLinkedList.insert(list, 4);
        SinglyLinkedList.insert(list, 101);
        SinglyLinkedList.insert(list, 102);
        SinglyLinkedList.insert(list, 103);
        SinglyLinkedList.insert(list, 104);        
        SinglyLinkedList result = rearrangeList(list);
        SinglyLinkedList.printList(result);
    }

    public static SinglyLinkedList rearrangeList (SinglyLinkedList list) {
        SinglyLinkedList.Node slowP = list.head;
        SinglyLinkedList.Node fastP = list.head;

        while (fastP != null && fastP.next !=null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
        }        
        
        fastP = list.head;
        SinglyLinkedList.Node current = list.head;
        SinglyLinkedList newList = new SinglyLinkedList();    
        //int i = 0;    
        while (slowP!=null) {
            SinglyLinkedList.insert(newList, fastP.data);                      
            SinglyLinkedList.insert(newList, slowP.data);
            slowP = slowP.next;
            fastP = fastP.next;
        }
        return newList;        
    }    
}
