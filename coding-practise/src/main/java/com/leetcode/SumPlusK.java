package com.leetcode;

import java.util.HashMap;
import java.util.Map;

// count number of pairs in an array which have difference of k
public class SumPlusK {

    public static void main(String[] args) {
        int ar [] = {1,7,5,9,2,12,3};
        int k = 2;

        System.out.println(countSumK(ar, k));
    }

    private static int countSumK(int ar[], int k) {
        Map<Integer,Integer> m = new HashMap<>();
        int count =0;
        for (int i:ar) {
            m.put(i,i);
        }

        for (int i =0;i<ar.length;i++) {
            if (m.get(ar[i]-k) !=null) 
                count ++;
        }


        return count;
    }
    
}
