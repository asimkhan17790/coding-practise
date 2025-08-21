package com.algos.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveDuplicates {

    public static void main(String[] args) {

        Integer [] ar = {0, 0, 1, 1, 1, 2, 2};
        List<Integer> list = Arrays.asList(ar);
        System.out.println(removeDuplicates(list));
    }

    public static int removeDuplicates(List<Integer> arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        int left=0,right=0;

        while (right<arr.size()) {
            if (!arr.get(right).equals(arr.get(left))){
                left++;
                arr.set(left,arr.get(right));
            }
            right++;
        }
        return left+1;
    }
}
