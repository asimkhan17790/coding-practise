package com.algos.twopointers;

import java.util.Scanner;

import java.util.*;

class Solution {
    public static String getMinimumWindow(String original, String check) {
        Map <Character,Integer> checkCount = new HashMap<>();
        Map <Character,Integer> windowCount = new HashMap<>();

        for (Character c : check.toCharArray()) {
            checkCount.put(c,checkCount.getOrDefault(c,0)+1);
        }

        int l = 0;
        int r = 0;
        String longest = "";
        int required = checkCount.size();
        int satisfied=0;
        int minLen = Integer.MAX_VALUE;
        int minStart=0;

        while (r < original.length()) {
            Character rChar= original.charAt(r);
            windowCount.put(rChar, windowCount.getOrDefault(rChar,0)+1);

            if (checkCount.containsKey(rChar) && windowCount.get(rChar).equals(checkCount.get(rChar))) {
                satisfied++;
            }

            while (satisfied == required){
                Character lChar = original.charAt(l);

                if ((r-l+1 < minLen) || (r-l+1== minLen) && original.substring(l,r+1).compareTo(original.substring(minStart,minStart+minLen))<0) {
                    minLen=r-l+1;
                    minStart=l;
                }
                windowCount.put(lChar, windowCount.get(lChar)-1);
                if (checkCount.containsKey(lChar) && windowCount.get(lChar)< checkCount.get(lChar)){
                    satisfied--;
                }
                l++;
            }
            r++;

        }

        return minLen == Integer.MAX_VALUE ? "" : original.substring(minStart, minStart + minLen);

        //return longest;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumWindow("AEOIEAIOUAOEIAOEIIAAEIUIOUUA","AEIOU"));
    }
}
