package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Given 2 "SORTED" arrays, find the number of elements in common.The arrays are of same length and each has all distinct elements.
public class FindCommonElementsIn2SortedArrays {
    public static void main(String[] args) {

        int ar1[] = {13,27,35,40,49,55,59};
        int ar2[] = {17,35,39,40,55,58,60};
        System.out.println(getCommonElements(ar1,ar2));
    }

    private static List<Integer> getCommonElements (int ar1[], int ar2[]) {
        List<Integer> list = new ArrayList<>();
        
        Map<Integer,Integer> l1 = Arrays.stream(ar1).boxed().collect(Collectors.toMap(e->e, e->e));      // BUT THIS ALGO TAKES O(N) SPACE. WE SHOULD USE O(1) SPACE and O(N) TIME
        
        for (int i = 0;i<ar2.length;i++) {
            if (l1.containsKey(ar2[i])) list.add(ar2[i]);
        }

        return list;
    }


    // USING O(1) SPACE and O(N) TIME - this can be done its its given that the arrays are sorted already, then we can assume beforehand
    private static List<Integer> getCommonElementsWithoutHashMap (int ar1[], int ar2[]) {
        
        
        
        
        }
}
