package com.educative.grokkingCodingInterview.pattern3FastAndSlowPointers;


public class CycleInACircularArray {

    public static boolean loopExists(int[] ar) {

        for (int i =0; i < ar.length; i++) {
            boolean isForward = ar[i]>=0;
            int slow = i;
            int fast = i;
            do {
                slow = findNextIndex(ar,isForward,slow);
                fast = findNextIndex(ar,isForward,fast);
                if (fast!=-1){
                    fast=findNextIndex(ar,isForward,fast);
                }
            }while(slow!=-1&&fast!=-1&&fast!=slow);

            if (slow!=-1 && slow==fast){
                return true;
            }
        }
        return false;
    }
    static int findNextIndex(int [] ar, boolean isForward, int currentIndex) {
        boolean direction = ar[currentIndex] >= 0;
        if (isForward != direction)
            return -1; // change in direction, return -1

        int nextIndex = (currentIndex + ar[currentIndex]) % ar.length;
        if (nextIndex < 0)
            nextIndex += ar.length; // wrap around for negative numbers

        // one element cycle, return -1
        if (nextIndex == currentIndex)
            nextIndex = -1;

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(CycleInACircularArray.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CycleInACircularArray.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CycleInACircularArray.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}