package com.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

*/ 
public class PermutationInString {
    
    public static void main(String[] args) {
        
    }

    public static boolean checkInclusion(String s1, String s2) {
    
        // JAVA Streams to the RESCUE!!!!
        Set<Character> set = s1.chars().mapToObj(e-> (char) e).collect(Collectors.toSet());

        for (int i = 0; i< s2.length() - s1.length(); i++) {
                if (set.contains(s2.charAt(i))) {
                    boolean flag = isPermutation (s1, s2.substring(i,i+s1.length()));
                    if (flag) return flag;
                }
        }

        return false;
    }
    private static boolean isPermutation (String s1, String s2) {

        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();

        Arrays.sort(ss1);
        Arrays.sort(ss2);

        for (int i = 0;i<s1.length();i++){
            if (ss1[i]!=ss2[i]) return false;

        }
        return true;
    }


    //sliding window logic
    public static boolean checkInclusion2(String s1, String s2) {
    
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }

        int freq1[] = new int[26];
        int freq2[] = new int [26];
        
        for (int i = 0; i < m; i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        for (int i = m;i<n; i++) {
            if (Arrays.equals(freq1,freq2)) return true;

            // else update the window
            
            // include current element in window
            freq2[s2.charAt(i) - 'a']++;

            // removing leftmost element from the window
            freq2[s2.charAt(i-m) - 'a']--;
        }

        if (Arrays.equals(freq1,freq2)) return true;
    
        return false;
    }
   
}
