package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// give 2 strings s:abbc and b:cbabadcbbabbcbabaabccbabc find index all permutations of b in s. The permutation should be contiguous.
public class FindStringinBiggerString {   

    public static void main(String[] args) {
        System.out.println(findLocations("cbabadcbbabbcbabaabccbabc", "abbc")); 
    }

    private static List<Integer> findLocations (String b, String s) {
        List<Integer> indexList = new ArrayList<>();

        // logic 1 - start
        Set<Character> set = new HashSet<>();
        //maptoObj converts Int Stream to Character stream over here
        s.chars().mapToObj(e->(char)e).forEach(e->set.add(e));

        for (int i = 0; i<= b.length()-s.length();i++) {
               if (set.contains(b.charAt(i))){
                   if (isPermutation(s, b.substring(i, i+s.length()))){
                    System.out.println(i);    
                    indexList.add(i);
                   }
               }
        }

        return indexList;       

    }

    private static boolean isPermutation (String s1, String s2) {

        System.out.println("String 1 =" +s1);
        System.out.println("String 2 =" +s2);

        if(s1.length() != s2.length()){
            return false;
        }
        char [] ss1 = s1.toCharArray();
        char [] ss2 = s2.toCharArray();

        Arrays.sort(ss1);
        Arrays.sort(ss2);

        for (int i = 0;i < ss1.length;i++) {
            if (ss1[i]!=ss2[i]) return false;
        }
        return true;
    }
}




